package ca.jrvs.apps.practice.codingChallenge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StackQueueUnitTest {

    StackQueue s1;
    StackQueue s2;

    @Before
    public void setUp() throws Exception {
        s1 = new StackQueue(true);
        s2 = new StackQueue(false);
        s1.push(1);
        s1.push(2);
        s1.push(3);
        s2.push(1);
        s2.push(2);
        s2.push(3);
    }

    @After
    public void tearDown() throws Exception {
    }

        @Test
    public void top() {
        assertEquals(3, s1.pop());
        assertEquals(2, s1.pop());
        assertEquals(1, s1.pop());
        assertEquals(-1, s1.pop());
        assertEquals(3, s2.pop());
        assertEquals(2, s2.pop());
        assertTrue(s1.top() == -1);
        assertTrue(s2.top() == 1);
    }

    @Test
    public void empty() {
        assertEquals(3, s1.pop());
        assertEquals(2, s1.pop());
        assertEquals(1, s1.pop());
        assertEquals(-1, s1.pop());
        assertEquals(3, s2.pop());
        assertEquals(2, s2.pop());
        assertTrue(s1.empty());
        assertFalse(s2.empty());
    }
}