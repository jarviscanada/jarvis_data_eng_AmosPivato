package ca.jrvs.apps.practice.codingChallenge;


import java.sql.Array;
import java.util.HashMap;
import java.util.Map;

/**
 * https://www.notion.so/jarvisdev/Two-Sum-bc8e9dbf5c91461a90b600664f112569
 */
public class TwoSum {

    /**
     * assuming that array is unsorted so two loops
     * is was sorted could do it in one loop by subtracting the ammount from target and if the next num is greater switch num etc..
     * time complexity O(n^2)
     * @param nums
     * @param target
     * @return array of indices of two numbers that add up to target
     */
    public int[] twoSum1(int[] nums, int target){
        int[] sum = new int[2];
        for (int i=0; i<nums.length-1; i++) {
            for (int j =i+1; j < nums.length; j++){
                if (nums[i] + nums[j] == target){
                    sum[0] = i;
                    sum[1] = j;
                    return sum;
                }
            }
        }
        return sum;
    }

    /**
     * time complexity O(n)
     * using dynamic programing and combications of the array elements to store vals in hash map to increse speed
     * @param nums
     * @param target
     * @return array of indices of two numbers that add up to target
     */
    public int[] twoSum2(int[] nums, int target){
        int[] sum = new int[2];
        Map map = new HashMap();
        for (int i =0; i< nums.length; i++){
            int num = nums[i];
            int diff = target - num;
            if (map.containsKey(diff)){
                sum[0] = (int) map.get(diff);
                sum[1] = i;
                return sum;
            }
            else {
                map.put(num, i);
            }
        }
        return sum;
    }
}
