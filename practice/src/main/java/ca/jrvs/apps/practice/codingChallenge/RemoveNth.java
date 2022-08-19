package ca.jrvs.apps.practice.codingChallenge;

import ca.jrvs.apps.practice.dataStructure.List.ListNode;

public class RemoveNth {

    /**
     * removes nth node from the back of linked list
     * @param head
     * @param n
     * @return head
     */
    public ListNode removeNth(ListNode head, int n){
        if (n > 0) {
            //find node
            ListNode found = head;
            ListNode curr = head;
            int count = 0;
            while (curr.next != null) {
                curr = curr.next;
                count += 1;
                if (count >= n+1){
                    found = found.next;
                }
            }
            //swap
            if (n == 1 && count == 0){
                head = null;
            }
            else if (n == 1 && count > 1){
                found.next =null;
            }
            else if (n > count){
                head = found.next;
            }
            else {
                ListNode temp = found.next.next;
                found.next = temp;
            }
        }
        return head;
    }
}
