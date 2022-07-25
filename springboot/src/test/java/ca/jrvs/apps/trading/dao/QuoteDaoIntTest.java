package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.TestConfig;
import ca.jrvs.apps.trading.model.domain.Quote;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
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
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class QuoteDaoIntTest {

    @Autowired
    private QuoteDao quoteDao;

    private Quote savedQuote;

    @Before
    public void insertOne(){
        savedQuote = new Quote();
        savedQuote.setAskPrice(10d);
        savedQuote.setAskSize(10l);
        savedQuote.setBidPrice(10.2d);
        savedQuote.setBidSize(10l);
        savedQuote.setId("TSLA");
        savedQuote.setLastPrice(10.1d);
        quoteDao.save(savedQuote);
    }

    @After
    public void deleteOne(){
        quoteDao.deleteById(savedQuote.getId());
    }

    @Test
    public void testA(){
        //test for save()
        savedQuote.setLastPrice(20.1d);
        quoteDao.save(savedQuote);
        Quote quote = quoteDao.findById("TSLA").get();
        assertTrue(20.1 == quote.getLastPrice());
    }

    @Test
    public void testB() {
        //test saveAll()
        List<Quote> quotes = new ArrayList<>();
        Quote q1 = new Quote();
        Quote q2 = new Quote();
        q1.setAskPrice(10d);
        q1.setAskSize(10l);
        q1.setBidPrice(10.2d);
        q1.setBidSize(10l);
        q1.setId("tsla");
        q1.setLastPrice(10.1d);
        q2.setAskPrice(10d);
        q2.setAskSize(10l);
        q2.setBidPrice(10.2d);
        q2.setBidSize(10l);
        q2.setId("aap");
        q2.setLastPrice(10.1d);
        quotes.add(q1);
        quotes.add(q2);
        quoteDao.saveAll(quotes);
        List<Quote> founds = quoteDao.findAll();
        assertEquals(3, founds.size());
    }

    @Test
    public void testC() {
        //test for find by id
        Optional<Quote> found = quoteDao.findById("TSLA");
        Optional<Quote> notfound = quoteDao.findById("aaple");
        assertTrue(found.isPresent());
        assertFalse(notfound.isPresent());
    }

    @Test
    public void testD() {
        //test for existsbyid
        assertTrue(quoteDao.existsById("TSLA"));
        assertFalse(quoteDao.existsById("apple"));
    }

    @Test
    public void testE() {
        //test for findall
        //test saveAll()
        List<Quote> quotes = new ArrayList<>();
        Quote q1 = new Quote();
        Quote q2 = new Quote();
        q1.setAskPrice(10d);
        q1.setAskSize(10l);
        q1.setBidPrice(10.2d);
        q1.setBidSize(10l);
        q1.setId("tsla");
        q1.setLastPrice(10.1d);
        q2.setAskPrice(10d);
        q2.setAskSize(10l);
        q2.setBidPrice(10.2d);
        q2.setBidSize(10l);
        q2.setId("aap");
        q2.setLastPrice(10.1d);
        quotes.add(q1);
        quotes.add(q2);
        quoteDao.saveAll(quotes);
        List<Quote> founds = quoteDao.findAll();
        assertEquals(3, founds.size());

    }

    @Test
    public void testF() {
        //test for count()
        assertEquals(1, quoteDao.count());
    }

    @Test
    public void testG() {
        //test for deletall\
        quoteDao.deleteAll();
        assertEquals(0, quoteDao.count());
    }
}