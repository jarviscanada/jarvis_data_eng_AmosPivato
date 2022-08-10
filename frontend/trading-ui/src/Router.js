import { Component } from "react";
import { BrowserRouter, Redirect, Route, Switch } from "react-router-dom";

import Dashboard from './page/Dashboard';

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
                </Switch>
            </BrowserRouter>
        )
    }
}