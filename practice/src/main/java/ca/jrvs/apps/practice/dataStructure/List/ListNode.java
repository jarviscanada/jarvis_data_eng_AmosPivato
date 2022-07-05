package ca.jrvs.apps.practice.dataStructure.List;

import java.util.ArrayList;
import java.util.List;

public class ListNode {
    public int val;
    public ListNode next;

    ListNode(){

    }
    ListNode(int val){
        this.val = val;
    }

    ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }

    public static ListNode BuildLinkedList(int[] ints){
        ListNode head = null;
        if (ints.length != 0){
            ListNode tempHead = new ListNode(ints[0]);
            head = tempHead;
            for (int i = 1; i < ints.length; i++){
                ListNode node = new ListNode(ints[i]);
                tempHead.next = node;
                tempHead = node;
            }
        }
        return head;
    }

    public static int[] BuildArray(ListNode head){
        List<Integer> list = new ArrayList<>();
        while (head != null){
            list.add(head.val);
            head = head.next;
        }
        return list.stream().mapToInt(i->i).toArray();
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "val=" + val +
                ", next=" + next +
                '}';
    }
}
