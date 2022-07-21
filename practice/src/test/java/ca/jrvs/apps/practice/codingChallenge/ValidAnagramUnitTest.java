package ca.jrvs.apps.practice.codingChallenge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidAnagramUnitTest {

    public ValidAnagram validAnagram;

    @Before
    public void setUp() throws Exception {
        System.out.println("test is set up");
        validAnagram = new ValidAnagram();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("test has completed");
    }

    @Test
    public void validAnagram1() {
        System.out.println("test valid anagram 1 begins");
        String s1 = "orchestra";
        String s2 = "carthorse";

        String s3 = "gamanra";
        String s4 = "anagram";

        String s5 = "nl";
        String s6 = "cx";

        String s7 = "anagram";
        String s8 = "nnagram";

        assertTrue(validAnagram.validAnagram1(s1, s2));
        assertTrue(validAnagram.validAnagram1(s3, s4));

        assertFalse(validAnagram.validAnagram1(s5, s6));
        assertFalse(validAnagram.validAnagram1(s7, s8));
    }

    @Test
    public void validAnagram2() {
        System.out.println("test valid anagram 2 begins");
        String s1 = "orchestra";
        String s2 = "carthorse";

        String s3 = "gamanra";
        String s4 = "anagram";

        String s5 = "nl";
        String s6 = "cx";

        String s7 = "anagram";
        String s8 = "nnagram";

        assertTrue(validAnagram.validAnagram2(s1, s2));
        assertTrue(validAnagram.validAnagram2(s3, s4));

        assertFalse(validAnagram.validAnagram2(s5, s6));
        assertFalse(validAnagram.validAnagram2(s7, s8));
    }
}