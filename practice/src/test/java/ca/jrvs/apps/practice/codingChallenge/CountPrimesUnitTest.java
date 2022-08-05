package ca.jrvs.apps.practice.codingChallenge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountPrimesUnitTest {

    public CountPrimes countPrimes;

    @Before
    public void setUp() throws Exception {
        System.out.println("setting up test cases");
        countPrimes = new CountPrimes();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("test case completed");
    }

    @Test
    public void countPrimes() {
        assertEquals(4 , countPrimes.countPrimes(10));
        assertEquals(41537 , countPrimes.countPrimes(499979));
        assertEquals(13848 , countPrimes.countPrimes(150000));
    }
}