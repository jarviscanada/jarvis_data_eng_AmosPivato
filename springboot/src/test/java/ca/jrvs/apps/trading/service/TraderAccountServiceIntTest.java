package ca.jrvs.apps.trading.service;

import ca.jrvs.apps.trading.TestConfig;
import ca.jrvs.apps.trading.dao.AccountDao;
import ca.jrvs.apps.trading.dao.TraderDao;
import ca.jrvs.apps.trading.model.domain.Account;
import ca.jrvs.apps.trading.model.domain.Trader;
import ca.jrvs.apps.trading.model.domain.TraderAccountView;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
@Sql({"classpath:schema.sql"})
public class TraderAccountServiceIntTest {

    private TraderAccountView savedView;

    @Autowired
    private TraderAccountService traderAccountService;
    @Autowired
    private TraderDao traderDao;
    @Autowired
    private AccountDao accountDao;

    @Before
    public void setUp() throws Exception {
        Trader trader = new Trader();
        trader.setCountry("Canada");
        trader.setId(null);
        trader.setEmail("bob@gmail.com");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String dateS = sdf.format(date);
        trader.setDob(sdf.parse(dateS));
        trader.setFirst_name("Bob");
        trader.setLast_name("Billy");
        savedView = traderAccountService.createTraderAndAccount(trader);

    }

    @After
    public void tearDown(){
        traderAccountService.deleteTraderById(savedView.getTrader_id());
    }

    @Test
    public void deposit() {
        try {
            traderAccountService.deposit(null, 100.0);
        } catch (IllegalArgumentException e){
            System.out.println("exception caught succesfully f or negative test");
        }
        Account depositedA = traderAccountService.deposit(savedView.getTrader_id(), 100d);
        assertTrue(depositedA.getAmount() == (savedView.getAmount()+100d));
        assertTrue(depositedA.getTrader_id() == savedView.getTrader_id());
        traderAccountService.withdraw(savedView.getTrader_id(), 100d);
    }

    @Test
    public void withdraw() {
        try {
            traderAccountService.withdraw(null, 100.0);
        } catch (IllegalArgumentException e){
            System.out.println("exception caught succesfully f or negative test");
        }
        try {
            traderAccountService.withdraw(savedView.getTrader_id(), 100.0);
        } catch (IllegalArgumentException e){
            System.out.println("caught exception succesfully for illegal withdrawal");
        }
        traderAccountService.deposit(savedView.getTrader_id(), 100d);
        savedView.setAmount(100d);
        Account depositedA = traderAccountService.withdraw(savedView.getTrader_id(), 100d);
        assertTrue(depositedA.getAmount() == (savedView.getAmount()-100d));
        assertTrue(depositedA.getTrader_id() == savedView.getTrader_id());
    }
}