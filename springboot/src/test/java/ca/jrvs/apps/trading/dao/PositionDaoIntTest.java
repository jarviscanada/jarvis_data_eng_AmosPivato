package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.TestConfig;
import ca.jrvs.apps.trading.model.domain.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
@Sql({"classpath:schema.sql"})
public class PositionDaoIntTest {

    @Autowired
    private PositionDao positionDao;
    private Position savedPosition;

    @Autowired
    private SecurityOrderDao securityOrderDao;
    private SecurityOrder savedOrder;

    @Autowired
    private AccountDao accountDao;
    private Account savedAccount;

    @Autowired
    private TraderDao traderDao;
    private Trader savedTrader;

    @Autowired
    private QuoteDao quoteDao;
    private Quote savedQuote;

    @Before
    public void setUp() throws ParseException {
        savedQuote = new Quote();
        savedQuote.setAskPrice(10d);
        savedQuote.setAskSize(10l);
        savedQuote.setBidPrice(10.2d);
        savedQuote.setBidSize(10l);
        savedQuote.setId("TSLA");
        savedQuote.setLastPrice(10.1d);
        quoteDao.save(savedQuote);

        savedTrader = new Trader();
        savedTrader.setCountry("Canada");
        savedTrader.setId(1);
        savedTrader.setEmail("bob@gmail.com");
        savedTrader.setDob(LocalDate.now());
        savedTrader.setFirst_name("Bob");
        savedTrader.setLast_name("Billy");
        traderDao.save(savedTrader);
        savedAccount = new Account();
        savedAccount.setId(1);
        savedAccount.setTrader_id(savedTrader.getId());
        savedAccount.setAmount(10d);
        accountDao.save(savedAccount);

        savedOrder = new SecurityOrder();
        savedOrder.setId(1);
        savedOrder.setAccount_id(savedAccount.getId());
        savedOrder.setNotes("new");
        savedOrder.setPrice(10d);
        savedOrder.setStatus("FILLED");
        savedOrder.setTicker("TSLA");
        savedOrder.setSize(10);
        securityOrderDao.save(savedOrder);
        savedPosition = positionDao.findAllById(Arrays.asList(1)).get(0);
    }

    @Test
    public void exists(){
        assertTrue(positionDao.existsById(savedPosition.getId()));
        Position found = positionDao.findById(savedPosition.getId()).get();
        assertEquals(savedPosition.getPosition(), found.getPosition());
    }

}