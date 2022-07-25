package ca.jrvs.apps.trading.dao;

import ca.jrvs.apps.trading.TestConfig;
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
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {TestConfig.class})
@Sql({"classpath:schema.sql"})
public class TraderDaoIntTest {

    @Autowired
    private TraderDao traderDao;

    private Trader savedTrader;

    @Before
    public void insertOne() throws ParseException {
        savedTrader = new Trader();
        savedTrader.setCountry("Canada");
        savedTrader.setId(2);
        savedTrader.setEmail("bob@gmail.com");
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSZ");
        String dateS = sdf.format(date);
        savedTrader.setDob(sdf.parse(dateS));
        savedTrader.setFirst_name("Bob");
        savedTrader.setLast_name("Billy");
        traderDao.save(savedTrader);
    }

    @After
    public void deleteOne(){
        traderDao.deleteById(savedTrader.getId());
    }

    @Test
    public void findAllById(){
        List<Trader> traders = Lists.newArrayList(traderDao.findAllById(Arrays.asList(savedTrader.getId())));
        assertEquals(1, traders.size());
        assertEquals(savedTrader.getCountry(), traders.get(0).getCountry());
    }

    @Test
    public void findbyId() {
        Trader found = traderDao.findById(1).get();
        assertTrue(found.getCountry().equals("Canada"));
    }
}