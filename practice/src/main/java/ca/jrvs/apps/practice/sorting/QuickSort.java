package ca.jrvs.apps.practice.sorting;

public class QuickSort {
    public static void quickSort(int arr[], int front, int end) {
        if (front < end) {
            int pivotIndex = partition(arr, front, end);
            quickSort(arr, front, pivotIndex-1);
            quickSort(arr, pivotIndex+1, end);
        }
    }

    public static int partition(int arr[], int begin, int end){
        int pivot = arr[end];
        int i = (begin-1);

        for (int j = begin; j < end; j++){
            if (arr[j] <= pivot){
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = temp;
        return i+1;
    }
}
