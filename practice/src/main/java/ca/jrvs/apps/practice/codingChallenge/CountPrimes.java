package ca.jrvs.apps.practice.codingChallenge;

public class CountPrimes {

    //first appraoch works but not for too big of an input, otherwise runs out of memory
    public int countPrimes(int n) {
//        boolean prime = true;
//        int num = n - 1; //so we are working with values less than n strictly
//        if (num <= 1){
//            return 0;
//        }
////        if (num == 2){
////            return 1;
////        }
//        else if (num > 2 && num % 2 == 0){
//            prime = false;
//        }
//        else {
//            int top = (int) Math.ceil(Math.sqrt(num)) + 1;
//            for (int i = 3; i < top; i = i + 2) { //will skip even numbers and checks only up till the squareroot of the num
//                if (num % i == 0) {
//                    prime = false;
//                    break;
//                }
//            }
//        }
//        if (prime){
//            return 1 + countPrimes(num);
//        }
//        else {
//            return countPrimes(num);
//        }
    //dynamic programing approach using map
        boolean[] primes = new boolean[n];

        for(int i=2; i*i<n ; i++){//inits array full of false to size of input as map of values that are not prime
            if(!primes[i]){

                for(int j = i*i; j<n; j+=i){ //prime math here to fill in map with all those that are not prime
                    primes[j] = true;
                }
            }
        }

        int count =0;

        for(int i = 2; i <n; i++){
            if(!primes[i]){
                count++;
            }
        }
        return count;
    }

}
