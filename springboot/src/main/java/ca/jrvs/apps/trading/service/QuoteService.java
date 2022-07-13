package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.dao.MarketDataDao;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import ca.jrvs.apps.trading.model.domain.Quote;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
@Service
public class QuoteService {

    private static final Logger logger = LoggerFactory.getLogger(QuoteService.class);

    private QuoteDao quoteDao;
    private MarketDataDao marketDataDao;

    @Autowired
    public QuoteService(QuoteDao quoteDao, MarketDataDao marketDataDao){
        this.quoteDao = quoteDao;
        this.marketDataDao = marketDataDao;
    }

    /**
     * find an iexquote
     * @param ticker id
     * @return iexqupte object
     * @throws IllegalArgumentException if ticker is invalid
     */
    public IexQuote findIexQuoteByTicker(String ticker){
        return marketDataDao.findById(ticker).orElseThrow(() -> new IllegalArgumentException(ticker + "is invalid"));
    }

    public List<IexQuote> findIexQuotesByTickers(Iterable<String> tickers){
        try {
            return marketDataDao.findAllById(tickers);
        } catch (Exception e){
            throw new IllegalArgumentException(tickers + "are invalid", e);
        }

    }

    /**
     * Update quote table against IEX source
     * - get all quotes from the db
     * - foreach ticker get iexquote
     * - convert iexquote to quote entity
     * - persist qupte to db
     *
     * @throws org.springframework.dao.DataAccessException if unable to retrive data
     * @throws IllegalArgumentException for invalid input
     */
    public void updateMarketData(){

    }

    /**
     * helper method map a iexqupte to a quote entity
     * note: iexquote.getLatestPrice() == null if the stock market is closed
     * make sure set a default value for number field(s)
     * @param iexQuote
     * @return
     */
    protected static Quote buildQuoteFromIexQuote(IexQuote iexQuote){

    }

    /**
     * validate (against IEX and save given tickers to quote table
     * - get iex quotes
     *  - convert each iexquote to quote entity
     *  - persist the quote to db
     *
     * @param tickers a list of tickers/symboles
     * @throws  IllegalArgumentException if ticker is not found IEX
     */
    public List<Quote> saveQuotes(List<String> tickers){

    }

    /**
     * helper method for savequotes
     * @param ticker
     */
    public Quote saveQuote(String ticker){

    }

    /**
     * update a given qupte to quote table without validation
     * @param quote entity
     *
     */
    public Quote saveQuote(Quote quote){
        return quoteDao.save(quote);
    }

    public List<Quote> findAllQuotes(){
        return quoteDao.findAll();
    }
}
