package ca.jrvs.apps.practice.codingChallenge;

public class FibonachiClimbingStairs {
    //int[] seq = new int[1000];

    public static int fcsRecursive(int n){
        if (n <= 1){
            return n;
        }
        else {
            return fcsRecursive(n-1) + fcsRecursive(n-2);
        }
    }

    public int fcsDynamic(int n){
        //both implementation pass unittest and are both dynamic.
//        if (n <= 1){
//            return n;
//        }
//        else if (seq[n] != 0){
//            return seq[n];
//        }
//        seq[n] = fcsDynamic(n-1) + fcsDynamic(n-2);
//        return seq[n];
        int[] seq = new int[n+2];
        int i;
        seq[0] = 0;
        seq[1] = 1;
        for (i = 2; i <= n; i++){
            seq[i] = seq[i-1] + seq[i-2];
        }
        return seq[n];
    }

}
