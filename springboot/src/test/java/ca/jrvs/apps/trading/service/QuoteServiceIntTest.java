package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.TestConfig;
import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.model.domain.IexQuote;
import ca.jrvs.apps.trading.model.domain.Quote;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
@Sql({"classpath:schema.sql"})
public class QuoteServiceIntTest {

    @Autowired
    private QuoteService quoteService;
    @Autowired
    private QuoteDao quoteDao;

    @Before
    public void setUp() {
        quoteDao.deleteAll();
    }

    @Test
    public void findIexQuoteByTicker() {
        IexQuote quote = quoteService.findIexQuoteByTicker("aapl");
        assertTrue(quote.getSymbol().equals("AAPL"));
        try {
            quoteService.findIexQuoteByTicker("apple");
        }catch (IllegalArgumentException e){
            System.out.println("passed illegal ticker");
        }

    }

    @Test
    public void updateMarketData() {
        List<String> tickers = new ArrayList<>();
        tickers.add("aapl");
        tickers.add("tsla");
        tickers.add("aap");
        List<Quote> savedQs = quoteService.saveQuotes(tickers);
        quoteService.updateMarketData();
        List<Quote> dbQuotes = quoteDao.findAll();
        assertTrue(savedQs.get(0).getTicker().equals(dbQuotes.get(0).getTicker()));
        assertTrue(savedQs.get(1).getTicker().equals(dbQuotes.get(1).getTicker()) );
        assertTrue(savedQs.get(2).getTicker().equals(dbQuotes.get(2).getTicker()));
    }

    @Test
    public void saveQuotes() {
        List<String> tickers = new ArrayList<>();
        tickers.add("aapl");
        tickers.add("tsla");
        tickers.add("aap");
        List<Quote> savedQs = quoteService.saveQuotes(tickers);
        List<Quote> dbQuotes = quoteDao.findAll();
        assertTrue(savedQs.get(0).getTicker().equals(dbQuotes.get(0).getTicker()));
        assertTrue(savedQs.get(1).getTicker().equals(dbQuotes.get(1).getTicker()) );
        assertTrue(savedQs.get(2).getTicker().equals(dbQuotes.get(2).getTicker()));
    }

    @Test
    public void saveQuote() {
        Quote quote = quoteService.saveQuote("aapl");
        Optional<Quote> dbquote = quoteDao.findById("aapl");
        assertTrue(quote.getTicker().equals(dbquote.get().getTicker()));
    }

    @Test
    public void findAllQuotes() {
        List<String> tickers = new ArrayList<>();
        tickers.add("aapl");
        tickers.add("tsla");
        tickers.add("aap");
        List<Quote> savedQs = quoteService.saveQuotes(tickers);
        List<Quote> dbQuotes = quoteDao.findAll();
        assertTrue(savedQs.get(0).getTicker().equals(dbQuotes.get(0).getTicker()));
        assertTrue(savedQs.get(1).getTicker().equals(dbQuotes.get(1).getTicker()) );
        assertTrue(savedQs.get(2).getTicker().equals(dbQuotes.get(2).getTicker()));
        assertTrue(dbQuotes.size() == 3);
    }
}