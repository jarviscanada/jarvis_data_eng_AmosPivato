package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.TestConfig;
import ca.jrvs.apps.trading.model.domain.Account;
import ca.jrvs.apps.trading.model.domain.SecurityOrder;
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
public class SecurityOrderDaoIntTest {

    @Autowired
    private SecurityOrderDao securityOrderDao;

    private SecurityOrder savedOrder;

    @Before
    public void insertOne() throws Exception {
        savedOrder = new SecurityOrder();
        savedOrder.setId(1);
        savedOrder.setAccount_id(1);
        savedOrder.setNotes("new");
        savedOrder.setPrice(10d);
        savedOrder.setStatus("pending");
        savedOrder.setTicker("aapl");
        savedOrder.setSize(10);
        securityOrderDao.save(savedOrder);
    }

    @After
    public void deleteOne() throws Exception {
        securityOrderDao.deleteById(savedOrder.getId());
    }

    @Test
    public void findAllbyId(){
        List<SecurityOrder> orders = Lists.newArrayList(securityOrderDao.findAllById(Arrays.asList(savedOrder.getId(), -1)));
        assertEquals(1, orders.size());
        assertEquals(savedOrder.getPrice(), orders.get(0).getPrice());
    }
}