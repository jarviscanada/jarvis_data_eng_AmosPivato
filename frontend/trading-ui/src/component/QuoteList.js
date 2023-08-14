import { Component } from "react";
import { Table } from "antd";
import 'antd/dist/antd.min.css';
import './QuoteList.scss';

export default class QuoteList extends Component {
    constructor(props) {
        super(props);

        const columns = [
            {
                title: 'Ticker',
                dataIndex: 'ticker',
                key: 'ticker',
            },
            {
                title: 'Last Price',
                dataIndex: 'lastPrice',
                key: 'lastPrice',
            },
            {
                title: 'Bid Price',
                dataIndex: 'bidPrice',
                key: 'bidPrice',
            },
            {
                title: 'Bid size',
                dataIndex: 'bidSize',
                key: 'bidSize',
            },
            {
                title: 'Ask Price',
                dataIndex: 'askPrice',
                key: 'askPrice',
            },
            {
                title: 'Ask Size',
                dataIndex: 'askSize',
                key: 'askSize',
            }
        ];
        this.state = {
            columns
        }
    }

    render(){
        return (
            <Table dataSource={ this.props.quotes } columns={ this.state.columns } pagination={ false } />
        );
    }
}