package ca.jrvs.apps.practice.codingChallenge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RotateStringUnitTest {

    public RotateString rotateString;

    @Before
    public void setUp() throws Exception {
        System.out.println("setting up test cases");
        rotateString = new RotateString();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("test case completed");
    }

    @Test
    public void rotateString() {
        String s1 = "abcde";
        String g1 = "cdeab";
        String g2 = "abced";
        String g3 = "aa";
        assertTrue(rotateString.rotateString(s1, g1));
        assertFalse(rotateString.rotateString(s1, g2));
        assertFalse(rotateString.rotateString(s1, g3));
    }
}