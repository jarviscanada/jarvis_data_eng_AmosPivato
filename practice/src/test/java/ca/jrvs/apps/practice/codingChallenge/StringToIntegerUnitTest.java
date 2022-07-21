package ca.jrvs.apps.practice.codingChallenge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringToIntegerUnitTest {

    public StringToInteger stringToInteger;

    @Before
    public void setUp() throws Exception {
        System.out.println("test case is about to start");
        stringToInteger = new StringToInteger();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("test case has concluded");
    }

    @Test
    public void stringToInt1() {
        System.out.println("testing string to int approach 1");
        String s1 = "42";
        String s2 = "    -42";
        String s3 = "4193 hello";
        String s4 = "hello 213 there";
        String s5 = "words and 987";

        assertEquals(42, stringToInteger.StringToInt1(s1));
        assertEquals(-42, stringToInteger.StringToInt1(s2));
        assertEquals(4193, stringToInteger.StringToInt1(s3));
        assertEquals(213, stringToInteger.StringToInt1(s4));
        assertEquals(987, stringToInteger.StringToInt1(s5));
    }

    @Test
    public void stringToInt2() {
        System.out.println("testing string to int approach 1");
        String s1 = "42";
        String s2 = "    -42";
        String s3 = "4193 hello";
        String s4 = "hello 213 there";
        String s5 = "words and 987";

        assertEquals(42, stringToInteger.StringToInt2(s1));
        assertEquals(-42, stringToInteger.StringToInt2(s2));
        assertEquals(4193, stringToInteger.StringToInt2(s3));
        assertEquals(213, stringToInteger.StringToInt2(s4));
        assertEquals(987, stringToInteger.StringToInt1(s5));
    }
}