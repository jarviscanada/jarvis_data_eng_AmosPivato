import { Component } from 'react';
import { NavLink } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAddressBook as dashboardIcon, faMoneyBill as quoteIcon} from '@fortawesome/free-solid-svg-icons';

import './NavBar.scss';

export default class Navbar extends Component {
    render(){
        return (
            <nav className="page-navigation">
                <NavLink to="/" className="page-navigation-header">
                    <></>
                </NavLink>
                <NavLink to="/traders" className="page-navigation-item">
                    <FontAwesomeIcon icon={ dashboardIcon } />
                </NavLink>
                <NavLink to="/quotes" className="page-navigation-item">
                    <FontAwesomeIcon icon={ quoteIcon } />
                </NavLink>
            </nav>
        );
    }
}