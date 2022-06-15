package ca.jrvs.apps.practice.search;

import java.util.Optional;

public class BinarySearch<E extends Comparable<E>>{
    /**
     * find the target in a sroted array
     * @param arr input array is sorted
     * @param target value to be searched
     * @return target index or optinal.empty if not found
     */
    public Optional<Integer> binarySearchRecursion(E[] arr, E target, int start, int end){
        int mid = (start + end)/2;
        if (end < start){
            return Optional.empty();
        }
        else if (target.compareTo(arr[mid]) < 0){
            return binarySearchRecursion(arr, target, start, mid -1);
        }
        else if (target.compareTo(arr[mid]) > 0){
            return binarySearchRecursion(arr, target, mid + 1, end);
        }
        else if (target.compareTo(arr[mid]) == 0){
            return Optional.of(mid);
        }
        return Optional.empty();
    }

    /**
     * find the target in a sroted array
     * @param arr input array is sorted
     * @param target value to be searched
     * @return target index or optinal.empty if not found
     */
    public Optional<Integer> binarySearchIteration(E[] arr, E target){
        int start = 0;
        int end = arr.length - 1;
        while (start <= end){
            int mid = (start + end)/2;
            if (target.compareTo(arr[mid]) < 0){
                end = mid - 1;
            }
            else if (target.compareTo(arr[mid]) > 0){
                start = mid + 1;
            }
            else if (target == arr[mid]){
                return Optional.of(mid);
            }
        }
        return Optional.empty();
    }
}
