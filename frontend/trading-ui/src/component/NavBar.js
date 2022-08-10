import { Component } from 'react';
import { NavLink } from 'react-router-dom';
import { FontAwesomeIcon } from '@fortawesome/react-fontawesome';
import { faAddressBook as dashboardIcon } from '@fortawesome/free-solid-svg-icons';

import './NavBar.scss';

export default class Navbar extends Component {
    render(){
        return (
            <nav className="page-navigation">
                <NavLink to="/" className="page-navigation-header">
                    <></>
                </NavLink>
                <NavLink to="/traders" className="page-navigation-header">
                    <FontAwesomeIcon icon={ dashboardIcon } />
                </NavLink>
            </nav>
        )
    }
}