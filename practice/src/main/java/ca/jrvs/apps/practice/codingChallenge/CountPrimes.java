package ca.jrvs.apps.practice.codingChallenge;

public class CountPrimes {

    public int countPrimes(int n) {
        boolean prime = true;
        int num = n - 1; //so we are working with values less than n strictly
        if (num <= 1){
            return 0;
        }
        int top = (int)Math.sqrt(num) + 1;
        for (int i = 2; i < top; i++){
            if (num % i == 0){
                prime = false;
                break;
            }
        }
        if (prime){
            return 1 + countPrimes(num);
        }
        else {
            return countPrimes(num);
        }
    }

}
