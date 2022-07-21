package ca.jrvs.apps.practice.codingChallenge;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.*;
import java.util.Arrays;

import static org.junit.Assert.*;

public class TwoSumUnitTest {

    private TwoSum twoSum;

    @Before
    public void setUp() throws Exception {
        System.out.println("about to start test case");
        twoSum = new TwoSum();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("test case has completed");
    }

    @Test
    public void twoSum1() {
        System.out.println("begining test for twosum1");
        int[] arr1 = {2, 7, 11, 15};
        int[] arr2 = {3, 2, 4};
        int[] arr3 = {0, 4, 3, 0};
        int[] arr4 = {3, 3};
        int[] expected1 = {0, 1};
        int[] expected2 = {1, 2};
        int[] expected3 = {0, 3};
        int[] expected4 = new int[2];
        int[] output1 = twoSum.twoSum1(arr1, 9);
        int[] output2 = twoSum.twoSum1(arr2, 6);
        int[] output3 = twoSum.twoSum1(arr3, 0);
        int[] output4 = twoSum.twoSum1(arr4, 6);
        int[] output5 = twoSum.twoSum1(arr1, 2);
        int[] output6 = twoSum.twoSum1(arr3, 7);
        assertArrayEquals(expected1, output1);
        assertArrayEquals(expected2, output2);
        assertArrayEquals(expected3, output3);
        assertArrayEquals(expected1, output4);
        assertArrayEquals(expected4, output5);
        assertArrayEquals(expected2, output6);
    }

    @Test
    public void twoSum2() {
        System.out.println("begining test for twosum1");
        int[] arr1 = {2, 7, 11, 15};
        int[] arr2 = {3, 2, 4};
        int[] arr3 = {0, 4, 3, 0};
        int[] arr4 = {3, 3};
        int[] expected1 = {0, 1};
        int[] expected2 = {1, 2};
        int[] expected3 = {0, 3};
        int[] expected4 = new int[2];
        int[] output1 = twoSum.twoSum2(arr1, 9);
        int[] output2 = twoSum.twoSum2(arr2, 6);
        int[] output3 = twoSum.twoSum2(arr3, 0);
        int[] output4 = twoSum.twoSum2(arr4, 6);
        int[] output5 = twoSum.twoSum2(arr1, 2);
        int[] output6 = twoSum.twoSum2(arr3, 7);
        assertArrayEquals(expected1, output1);
        assertArrayEquals(expected2, output2);
        assertArrayEquals(expected3, output3);
        assertArrayEquals(expected1, output4);
        assertArrayEquals(expected4, output5);
        assertArrayEquals(expected2, output6);
        //to test without worrying about equals use array.equals in assertTrue this way we don't worry about order of output but im lazy so i hardcoded output in method
    }
}