package ca.jrvs.apps.practice.codingChallenge;


import com.sun.xml.internal.ws.util.StringUtils;

import java.util.regex.Pattern;

public class ValidPalindrome {

    /**
     * check if string is a vlaid palindrome using twp pointers
     * @param s
     * @return true of false if valid or not
     */
    public boolean validPalindrome1(String s){
        String sc = cleaner(s);
        if (sc.length() > 0){
            char pointer1;
            char pointer2;
            int i = 0;
            int j = sc.length() - 1;
            while (i < j) {
                pointer1 = sc.charAt(i);
                pointer2 = sc.charAt(j);
                if (pointer1 != pointer2) {
                    return false;
                }
                i++;
                j--;
            }
        }
        return true;
    }

    /**
     * check if string is a vlaid palindrome using recurison
     * @param s
     * @return true of false if valid or not
     */
    public boolean validPalindrome2(String s){
        Pattern p = Pattern.compile("[^a-z0-9]");
        if (p.matcher(s).find()){
            s = cleaner(s);
        }
        if (s.length() <= 1){
            return true;
        }
        else{
            if(s.charAt(0) == s.charAt(s.length()-1)){
                s = s.substring(1, s.length()-1);
            }
            else {
                return false;
            }
        }
        return validPalindrome1(s);
    }

    /**
     * cleans string so that is does not contain any uppercase or non-alphanumeric characters
     * @param s
     * @return
     */
    private String cleaner(String s){
        if (s == null){
            return null;
        }
        return s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    }
}

