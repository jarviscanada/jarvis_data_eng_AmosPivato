package ca.jrvs.apps.practice.codingChallenge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PrintLetterNumberTest {

    public PrintLetterNumber printLetterNumber;

    @Before
    public void setUp() throws Exception {
        System.out.println("setting up test cases");
        printLetterNumber = new PrintLetterNumber();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("test case completed");
    }

    @Test
    public void printLetterNumber() {
        String s1 = "abc ABC";
        assertTrue(printLetterNumber.printLetterNumber(s1).equals("a1b2c3 A27B28C29"));
    }
}