import {Component} from 'react';
import Navbar from '../component/NavBar';
import { withRouter } from 'react-router';

import "./Dashboard.scss";

export default withRouter(class Dashboard extends Component {
    constructor(props){
        super(props);
    }
    render (){
        return (
            <div className="dashboard">
                <Navbar />
                <div className="dashboard-content">
                    Dashboard
                </div>                
            </div>
        );
    }
}); 