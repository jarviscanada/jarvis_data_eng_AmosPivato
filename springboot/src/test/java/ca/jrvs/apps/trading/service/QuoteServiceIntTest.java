package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.TestConfig;
//import ca.jrvs.apps.trading.dao.QuoteDao;
import ca.jrvs.apps.trading.model.domain.Quote;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
@Sql({"classpath:schema.sql"})
public class QuoteServiceIntTest {

    @Autowired
    private QuoteService quoteService;
    //@Autowired
//    private QuoteDao quoteDao;
//
//    @Before
//    public void setUp() {
//        quoteDao.deleteAll();
//    }

    @Test
    public void findIexQuoteByTicker() {

    }

    @Test
    public void updateMarketData() {
    }

    @Test
    public void saveQuotes() {
    }

    @Test
    public void saveQuote() {
    }

    @Test
    public void findAllQuotes() {
    }
}