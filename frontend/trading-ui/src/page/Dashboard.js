import React, {Component} from 'react';
import Navbar from '../component/NavBar';
import { withRouter } from 'react-router';
import { Input, DatePicker, Modal, Button, Form } from 'antd';
import axios from 'axios';
import {createTraderUrl, deleteTraderUrl, tradersUrl} from '../utils/constants';
import "./Dashboard.scss";
import TraderList from '../component/TraderList';
import 'antd/dist/antd.min.css';
import { createRef } from 'react';

export default withRouter(class Dashboard extends Component {
    constructor(props){
        super(props);
        //to bind method to the compponent contructor so they can set the states
        this.showModal = this.showModal.bind(this);
        this.handleOk = this.handleOk.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.onInputChange = this.onInputChange.bind(this);
        this.onTraderDelete = this.onTraderDelete.bind(this);
        this.state = {
            isModalVisible: false,
            traders: []
        }
        this.formRef = createRef();
    }

    async componentDidMount(){
        //fetch traders
        await this.getTraders();
    }

    async getTraders(){
        const response = await axios.get(tradersUrl);
        if (response) {
            this.setState({
                traders: response.data || []
            })
        }
    }

    //method that sets if the modal for adding traders is visible or not
    showModal() {
        this.setState({
            isModalVisible: true
        });
    };

    async handleOk() {
        //here we would send requests to the backend to create a new trader
        // await this.getTraders();
        // this.setState({
        //     isModalVisible: false,
        //     firstName:null,
        //     lastName: null, 
        //     dob: null,
        //     country: null,
        //     email: null
        // });

        const paramUrl = `/firstname/${this.state.first_name}/lastname/${this.state.last_name}/dob/${this.state.dob}/country/${this.state.country}/email/${this.state.email}`;
        const response = await axios.post(createTraderUrl + paramUrl, {});
        await this.getTraders();
        this.setState({
            isModalVisible: false
        })
    };

    handleCancel() {
        //close the modal
        this.setState({
            isModalVisible: false
        });
    }

    onInputChange(field, value) {
        this.setState({
            [field]: value
        });
    }

    async onTraderDelete(id){
        //senda request to backend to delete the trader with the specific id
        const paramUrl = "/" + id;
        const response = await axios.delete(deleteTraderUrl + paramUrl);
        //refresh trader list
        await this.getTraders();
        console.log("Trader " + id + "is deleted.");
    }




    render (){
        return (
            <div className="dashboard">
                <Navbar />
                <div className="dashboard-content">
                    <div className="title">
                        Dashboard
                        <div className="add-trader-button">
                            <Button onClick={this.showModal.bind(this)}>Add new Trader</Button>
                            <Modal 
                                title="Add New Trader" 
                                okText="Submit" 
                                visible={this.state.isModalVisible}
                                onCancel={this.handleCancel} 
                                onOk={() => {
                                    this.formRef.current
                                    .validateFields()
                                    .then((valies) => {
                                        this.formRef.current.resetFields();
                                        this.handleOk(); 
                                    })              
                                    .catch((info) => {
                                        console.warn('Validate Failed:', info);
                                    });
                                }}
                            >
                                <form 
                                    ref={this.formRef}
                                    layout="Vertical"
                                    onSubmit={this.handleOk}
                                >
                                    <div className="add-trader-form">
                                        <div className="add-trader-field">
                                            <Form.Item 
                                                label="First Name"
                                                name="First Name"
                                                rules={[
                                                    {
                                                        required: true,
                                                    },
                                                ]}
                                            >
                                                <Input allowClear={false} placeholder="john" onChange={(event) => this.onInputChange("first_name", event.target.value)} />
                                            </Form.Item>
                                        </div>
                                        <div className="add-trader-field">
                                            <Form.Item 
                                                label="Last Name"
                                                name="Last Name"
                                                rules={[
                                                    {
                                                        required: true,
                                                    },
                                                ]}
                                            >
                                                <Input allowClear={false} placeholder="Beck" onChange={(event) => this.onInputChange("last_name", event.target.value)} />
                                            </Form.Item>
                                        </div>
                                        <div className="add-trader-field">
                                            <Form.Item 
                                                label="Email"
                                                name="Email"
                                                rules={[
                                                    {
                                                        required:true,
                                                        message: "a valid email must be entered",
                                                        pattern: new RegExp(/^[\w-\.]+@([\w-]+\.)+[\w-]{2,4}$/),
                                                    },
                                                ]}
                                            >
                                                <Input allowClear={false} placeholder="john@test.com" onChange={(event) => this.onInputChange("email", event.target.value)} />
                                            </Form.Item>
                                        </div>
                                        <div className="add-trader-field">
                                            <Form.Item 
                                                label="Country"
                                                name="Country"
                                                rules={[
                                                    {
                                                        required: true,
                                                    },
                                                ]}
                                            >
                                                <Input allowClear={false} placeholder="Canada" onChange={(event) => this.onInputChange("country", event.target.value)} />
                                            </Form.Item>
                                        </div>
                                        <div className="add-trader-field">
                                            <Form.Item 
                                                label="Date of Birth"
                                                name="Date of Birth"
                                                rules={[
                                                    {
                                                    required: true,
                                                    },
                                                ]}
                                            >
                                                <DatePicker style={{width:"100%"}} placeholder="" onChange={(date, dateString) => this.onInputChange("dob", date.format("yyy-MM-DD"))} />
                                            </Form.Item>
                                        </div>
                                    </div>
                                </form>
                            </Modal>
                        </div>
                    </div>
                    <TraderList onTraderDeleteClick={this.onTraderDelete} traders={this.state.traders} />  
                </div>                              
            </div>
        );
    }
}); 