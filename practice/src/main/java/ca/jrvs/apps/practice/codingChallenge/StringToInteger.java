package ca.jrvs.apps.practice.codingChallenge;

public class StringToInteger {

    /**
     * convert string to usigned 32 bit integer using java built in methods
     * @param s
     * @return integer of s
     */
    public int StringToInt1(String s){
        int sign = 1;
        int num = 0;
        String nums = "";
        for (int i =0; i < s.length(); i++){
            Character currChar = s.charAt(i);
            if (!Character.isWhitespace(currChar)){
                if (Character.compare(currChar, '-') == 0){
                    sign = -1;
                }
                if (Character.compare(currChar, '+') == 0){
                    sign = 1;
                }
                else {
                    if (Character.isDigit(currChar)){
                        nums = nums + currChar;
                        if (i+1 < s.length()){
                            if (!Character.isDigit(s.charAt(i+1))){
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (nums.length() > 0){
            try {
                num = Integer.parseInt(nums);
            } catch (NumberFormatException e){
                num = Integer.MAX_VALUE;
            }
        }
        return num * sign;
    }

    /**
     * convert string to unsigned 32 bit integer without java built in methods
     * @param s
     * @return integer or s
     */
    public int StringToInt2(String s){
        int sign = 1;
        int num = 0;
        String nums = "";
        for (int i =0; i < s.length(); i++){
            Character currChar = s.charAt(i);
            if (!Character.isWhitespace(currChar)){
                if (Character.compare(currChar, '-') == 0){
                    sign = -1;
                }
                if (Character.compare(currChar, '+') == 0){
                    sign = 1;
                }
                else {
                    if (Character.isDigit(currChar)){
                        nums = nums + currChar;
                        if (i+1 < s.length()){
                            if (!Character.isDigit(s.charAt(i+1))){
                                break;
                            }
                        }
                    }
                }
            }
        }
        if (nums.length() > 0){
            for (int j = 0; j<nums.length(); j++){
                try {
                    num = Math.addExact(num * 10, ((int)nums.charAt(j) - 48));
                }
                catch (ArithmeticException e){
                    num = Integer.MAX_VALUE;
                }
            }
        }
        return num * sign;
    }
}
