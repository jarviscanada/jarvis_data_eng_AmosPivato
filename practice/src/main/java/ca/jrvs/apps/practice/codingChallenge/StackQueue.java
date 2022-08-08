package ca.jrvs.apps.practice.codingChallenge;

import java.util.LinkedList;
import java.util.Queue;

public class StackQueue {

    Boolean qeues;
    Queue<Integer> q1;

    /**
     * stack using queues
     * if true, make a stack using one queue, if false makes its with two
     */
    public StackQueue(boolean one){
        qeues = one;
        q1 = new LinkedList<>();
    }

    public void push(int x) {
        if (qeues){
            int size = q1.size();
            q1.add(x);
            for (int i = 0; i < size; i++){
                int val = q1.remove();
                q1.add(val);
            }
        }
        else{
            Queue<Integer> q2 = new LinkedList<>();
            if (q1.isEmpty()){
                q1.add(x);
            }
            else {
                q2.add(x);
                while (q1.isEmpty() == false) {
                    q2.add(q1.remove());
                }
                q1 = q2;
                //q2.clear();
            }
        }
    }

    public int pop() {
        if (q1.isEmpty()){
            return -1;
        }
        else {
            return q1.remove();
        }
    }

    public int top() {
        if (q1.isEmpty()){
            return -1;
        }
        else {
            return q1.peek();
        }
    }

    public boolean empty() {
        return q1.isEmpty();
    }
}
