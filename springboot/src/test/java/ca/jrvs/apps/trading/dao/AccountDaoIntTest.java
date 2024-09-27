package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.TestConfig;
import ca.jrvs.apps.trading.model.domain.Account;
import ca.jrvs.apps.trading.model.domain.Trader;
import org.assertj.core.util.Lists;
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
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
@Sql({"classpath:schema.sql"})
public class AccountDaoIntTest {

    @Autowired
    private AccountDao accountDao;
    private Account savedAccount;

    @Autowired
    private TraderDao traderDao;
    private Trader savedTrader;

    @Before
    public void insertOne() throws ParseException {
        savedTrader = new Trader();
        savedTrader.setCountry("America");
        savedTrader.setId(1);
        savedTrader.setEmail("dam@gmail.com");
        savedTrader.setDob(LocalDate.now());
        savedTrader.setFirst_name("James");
        savedTrader.setLast_name("boy");
        traderDao.save(savedTrader);
        savedAccount = new Account();
        savedAccount.setId(1);
        savedAccount.setTrader_id(1);
        savedAccount.setAmount(10d);
        accountDao.save(savedAccount);
    }

    @After
    public void deleteOne(){
        accountDao.deleteById(savedAccount.getId());
        traderDao.deleteById(savedTrader.getId());
    }

    @Test
    public void findAllById(){
        List<Account> accounts = Lists.newArrayList(accountDao.findAllById(Arrays.asList(savedAccount.getId())));
        assertEquals(1, accounts.size());
        assertEquals(savedAccount.getAmount(), accounts.get(0).getAmount());
    }
}