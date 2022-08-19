package ca.jrvs.apps.practice.codingChallenge;


import org.w3c.dom.NodeList;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class ValidParenthesis {

    public boolean ValidParentheses(String s){
        boolean valid = true;
        if (s.length() > 1) {
            int[] map = new int[3];
            Deque<Character> stack = new ArrayDeque<>();
            for (int i = 0; i< s.length(); i++) {
                switch (s.charAt(i)) {
                    case '(':
                        map[0]++;
                        stack.push(s.charAt(i));
                        break;
                    case '[':
                        map[1]++;
                        stack.push(s.charAt(i));
                        break;
                    case '{':
                        map[2]++;
                        stack.push(s.charAt(i));
                        break;
                    case ')':
                        try {
                            if (stack.peek() == '(') {
                                stack.pop();
                                map[0]--;
                            } else {
                                return false;
                            }
                        } catch (NullPointerException e){
                            return false;
                        }
                        break;
                    case ']':
                        try {
                            if (stack.peek() == '[') {
                                stack.pop();
                                map[1]--;
                            } else {
                                return false;
                            }
                        } catch (NullPointerException e){
                            return false;
                        }
                        break;
                    case '}':
                        try {
                            if (stack.peek() == '{') {
                                stack.pop();
                                map[2]--;
                            } else {
                                return false;
                            }
                        } catch (NullPointerException e){
                            return false;
                        }
                        break;
                }
            }
            valid = Arrays.stream(map).allMatch(i -> i ==0);
        }
        else {
            valid = false;
        }
        return valid;
    }
}
