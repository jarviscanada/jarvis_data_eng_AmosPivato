package ca.jrvs.apps.practice.codingChallenge;

public class RotateString {

    public boolean rotateString(String s, String goal) {
        String temps = s;
        boolean valid = false;
        if (s.length() == 0 || goal.length() == 0 || s.length() != goal.length()){
            return false;
        }
        int i = 0;
        if (s.contains(goal)){
            return true;
        }
        while (i < s.length()) {
            char c = temps.charAt(0);
            temps = temps.substring(1,s.length()) + c;
            if (temps.contains(goal)){
                return true;
            }
            i++;
        }
        return false;
    }
}
