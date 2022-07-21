package ca.jrvs.apps.practice.codingChallenge;

public class ValidAnagram {

    public boolean validAnagram1(String s, String t){
        String sorteds = s.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        String sortedt = t.chars().sorted().collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
        return sorteds.equals(sortedt);
    }

    public boolean validAnagram2(String s, String t){
        if (!(s.length() == t.length())){
            return false;
        }
        //using array as hashmap where index is key of letter of the alphabet, assuming lower case caracters only
        int[] counter = new int[26];
        //add and subtract increments from counter hashmap as a way of counting which chars are present in each string
        //if any value remains then strings are not anagrams of each other
        for (int i = 0; i < s.length(); i++){
            int sindex = s.charAt(i) - 97;
            int tindex = t.charAt(i) - 97;
            counter[sindex] = counter[sindex] + 1;
            counter[tindex] = counter[tindex] - 1;
        }
        for (int j = 0; j < s.length(); j++){
            int sindex = s.charAt(j) - 97;
            if (counter[sindex] != 0)
                return false;
        }
        return true;
    }
}
