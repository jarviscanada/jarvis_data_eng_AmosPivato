package ca.jrvs.apps.practice.codingChallenge;

import ca.jrvs.apps.practice.dataStructure.List.ListNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveNthUnitTest {

    private RemoveNth removeNth;

    @Before
    public void setUp() throws Exception {
        removeNth = new RemoveNth();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void removeNth() {
        int[] array = {1,2,3,4,5};
        int[] expected = {1,2,3,5};
        ListNode linkedList = ListNode.BuildLinkedList(array);
        linkedList = removeNth.removeNth(linkedList, 2);
        int[] result = ListNode.BuildArray(linkedList);
        assertArrayEquals(expected, result);

        int[] array1 = {1};
        int[] expected1 = {};
        ListNode linkedList1 = ListNode.BuildLinkedList(array1);
        linkedList1 = removeNth.removeNth(linkedList1, 1);
        int[] result1 = ListNode.BuildArray(linkedList1);
        assertArrayEquals(expected1, result1);

        int[] array2 = {1, 2, 3};
        int[] expected2 = {2,3};
        ListNode linkedList2 = ListNode.BuildLinkedList(array2);
        linkedList2 = removeNth.removeNth(linkedList2, 3);
        int[] result2 = ListNode.BuildArray(linkedList2);
        assertArrayEquals(expected2, result2);
    }
}