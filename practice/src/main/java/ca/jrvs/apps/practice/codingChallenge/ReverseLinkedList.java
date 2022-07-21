package ca.jrvs.apps.practice.codingChallenge;

import ca.jrvs.apps.practice.dataStructure.List.ListNode;


public class ReverseLinkedList {

    /**
     * reverse a linked list iteratively
     * @param head
     * @return head of reverse linked list
     */
    public ListNode reverseList1(ListNode head){
        if (head != null) {
            ListNode tempHead = head;
            ListNode tempNext = head.next;
            ListNode tempPrev = head;
            tempPrev.next = null;
            while (tempNext != null){
                tempHead = tempNext;
                tempNext = tempNext.next;
                tempHead.next = tempPrev;
                tempPrev = tempHead;
            }
            head = tempHead;
        }
        return head;
    }

    /**
     * reverse linked list recursively
     * @param head
     * @return head of reversed linked list
     */
    public ListNode reverseList2(ListNode head){
        if (head == null){
            return head;
        }
        else {
            ListNode next = head.next;
            if (next == null){
                return head;
            }
            ListNode prev = head;
            prev.next = null;
            if (next.next != null){
                head = reverseList2(next);
                next.next = prev;
            }
            else {
                head = next;
                head.next = prev;
            }
            return head;
        }
    }
}
