import axios from 'axios';
import { Component } from 'react';
import { withRouter } from 'react-router';
import Navbar from '../component/NavBar';
import { dailyListQuotesUrl } from '../utils/constants';
import 'antd/dist/antd.min.css';
import "./Quote.scss";
import QuoteList from '../component/QuoteList';

export default withRouter(class QuotePage extends Component {
    constructor(props) {
        super(props);
        this.state = {
            quotes: []
        };
    }
    async componentDidMount() {
        //fetch quotes
        const response = await axios.get(dailyListQuotesUrl);
        if (response) {
            this.setState({
                quotes: response.data.map(data => ({...data, key: data.ticker})) || []
            });
        }
    }

    render () {
        //render quotes page
        return (
            <div className="quote-page">
                <Navbar />
                <div className="quote-page-content">
                    <div className="title">
                        Quotes
                    </div>
                    <QuoteList quotes={ this.state.quotes } />
                </div>
            </div>
        );
    }
});