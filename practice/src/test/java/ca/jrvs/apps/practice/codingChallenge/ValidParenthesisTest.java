package ca.jrvs.apps.practice.codingChallenge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ValidParenthesisTest {

    ValidParenthesis validParenthesis;

    @Before
    public void setUp() throws Exception {
        System.out.println("setting up test case");
        validParenthesis = new ValidParenthesis();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("closing test case");
    }

    @Test
    public void validParentheses() {
        System.out.println("starting test case for valid parentheses");
        String s1 = "()";
        String s2 = "()[]{}";
        String s3 = "((";
        String s4 = "(){[])";
        String s5 = "{(())}";
        assertTrue(validParenthesis.ValidParentheses(s1));
        assertTrue(validParenthesis.ValidParentheses(s2));
        assertFalse(validParenthesis.ValidParentheses(s3));
        assertFalse(validParenthesis.ValidParentheses(s4));
        assertFalse(validParenthesis.ValidParentheses("("));
        assertFalse(validParenthesis.ValidParentheses("}{"));
        assertTrue(validParenthesis.ValidParentheses(s5));
    }
}