package ca.jrvs.apps.practice.codingChallenge;

/*
ticket https://www.notion.so/jarvisdev/Sample-Check-if-a-number-is-even-or-odd-653755e3268d4eff9a348bb63104c2b5
 */
public class OddEven {
    /**
     *BigO(1)
     * arithmatic operation
     * @param i
     * @return String even or odd
     */
    public String oddEvenMod(int i){
        return i% 2 == 0 ? "even" : "odd";
    }

    /**
     * BigO(1)
     * atomic bitwise operation
     * @param i
     * @return String even or odd
     */
    public String oddEvenBit(int i){
        if ((i ^ 1) == i+1){
            return "even";
        }
        else {
            return "odd";
        }
    }
}