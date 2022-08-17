import { Component } from "react";
import { BrowserRouter, Redirect, Route, Switch } from "react-router-dom";

import Dashboard from './page/Dashboard';
import QuotePage from './page/Quote';

export default class Router extends Component {
    render() {
        return (
            <BrowserRouter>
                <Switch>
                    <Route exact path="/">
                        <Redirect to="/dashboard" />
                    </Route>
                    <Route exact path="/dashboard">
                        <Dashboard />
                    </Route>
                    <Route exact path ="/traders">
                        <Redirect to="/dashboard" />
                    </Route>
                    <Route exact path ="/quotes">
                        <QuotePage />
                    </Route>
                </Switch>
            </BrowserRouter>
        );
    }
}