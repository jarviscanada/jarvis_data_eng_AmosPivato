package ca.jrvs.apps.practice.codingChallenge;

public class PrintLetterNumber {

    public String printLetterNumber(String s){
        //Character[] chars = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z','A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
        String out = "";
        for (int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if (Character.isAlphabetic(c)) {
                if (Character.isUpperCase(c)) {
                    out = out + c + ((int) c - 65 + 27);
                } else {
                    out = out + c + ((int) c - 96);
                }
            }
            else{
                out = out + c;
            }
        }
        return out;
    }
}
