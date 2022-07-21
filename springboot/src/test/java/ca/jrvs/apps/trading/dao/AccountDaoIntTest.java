package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.TestConfig;
import ca.jrvs.apps.trading.model.domain.Account;
import org.assertj.core.util.Lists;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;


import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
@Sql({"classpath:schema.sql"})
public class AccountDaoIntTest {

    @Autowired
    private AccountDao accountDao;

    private Account savedAccount;

    @Before
    public void insertOne(){
        savedAccount = new Account();
        savedAccount.setId(1);
        savedAccount.setTrader_id(1);
        savedAccount.setAmount(10d);
        accountDao.save(savedAccount);
    }

    @After
    public void deleteOne(){
        accountDao.deleteById(savedAccount.getId());
    }

    @Test
    public void findAllById(){
        List<Account> accounts = Lists.newArrayList(accountDao.findAllById(Arrays.asList(savedAccount.getId(), -1)));
        assertEquals(1, accounts.size());
        assertEquals(savedAccount.getAmount(), accounts.get(0).getAmount());
    }
}