package ca.jrvs.apps.practice.codingChallenge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidPalindromeTest {

    ValidPalindrome validPalindrome;

    @Before
    public void setUp() throws Exception {
        System.out.println("setting up test case");
        validPalindrome = new ValidPalindrome();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Closing test case");
    }

    @Test
    public void validPalindrome1() {
        System.out.println("performing test valid palindrome 1");
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = ".";
        String s3 = ".,";
        assertTrue( validPalindrome.validPalindrome1(s1));
        assertTrue( validPalindrome.validPalindrome1(s2));
        assertTrue( validPalindrome.validPalindrome1(s3));
    }

    @Test
    public void validPalindrome2() {
        System.out.println("performing test valid palindrome 2");
        String s1 = "A man, a plan, a canal: Panama";
        String s2 = ".";
        String s3 = ".,";
        assertTrue( validPalindrome.validPalindrome2(s1));
        assertTrue( validPalindrome.validPalindrome2(s2));
        assertTrue( validPalindrome.validPalindrome2(s3));
    }
}