package ca.jrvs.apps.practice.codingChallenge;

import ca.jrvs.apps.practice.dataStructure.List.ListNode;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    public ReverseLinkedList reverseLinkedList;

    @Before
    public void setUp() throws Exception {
        System.out.println("preparing test case");
        reverseLinkedList = new ReverseLinkedList();
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("concluding test case");
    }

    @Test
    public void reverseList1() {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1};
        int[] arr3 = {};
        int[] arr4 = {1,2,3};
        ListNode head1 = ListNode.BuildLinkedList(arr1);
        ListNode head2 = ListNode.BuildLinkedList(arr2);
        ListNode head3 = ListNode.BuildLinkedList(arr3);
        ListNode head4 = ListNode.BuildLinkedList(arr4);
        int[] result1 = ListNode.BuildArray(reverseLinkedList.reverseList1(head1));
        int[] result2 = ListNode.BuildArray(reverseLinkedList.reverseList1(head2));
        int[] result3 = ListNode.BuildArray(reverseLinkedList.reverseList1(head3));
        int[] result4 = ListNode.BuildArray(reverseLinkedList.reverseList1(head4));
        int[] exp1 = {5,4,3,2,1};
        int[] exp2 = {1};
        int[] exp3 = {};
        int[] exp4 = {3,2,1};
        assertArrayEquals(exp1, result1);
        assertArrayEquals(exp2, result2);
        assertArrayEquals(exp3, result3);
        assertArrayEquals(exp4, result4);
    }

    @Test
    public void reverseList2() {
        int[] arr1 = {1,2,3,4,5};
        int[] arr2 = {1};
        int[] arr3 = {};
        int[] arr4 = {1,2,3};
        ListNode head1 = ListNode.BuildLinkedList(arr1);
        ListNode head2 = ListNode.BuildLinkedList(arr2);
        ListNode head3 = ListNode.BuildLinkedList(arr3);
        ListNode head4 = ListNode.BuildLinkedList(arr4);
        int[] result1 = ListNode.BuildArray(reverseLinkedList.reverseList2(head1));
        int[] result2 = ListNode.BuildArray(reverseLinkedList.reverseList2(head2));
        int[] result3 = ListNode.BuildArray(reverseLinkedList.reverseList2(head3));
        int[] result4 = ListNode.BuildArray(reverseLinkedList.reverseList2(head4));
        int[] exp1 = {5,4,3,2,1};
        int[] exp2 = {1};
        int[] exp3 = {};
        int[] exp4 = {3,2,1};
        assertArrayEquals(exp1, result1);
        assertArrayEquals(exp2, result2);
        assertArrayEquals(exp3, result3);
        assertArrayEquals(exp4, result4);
    }
}