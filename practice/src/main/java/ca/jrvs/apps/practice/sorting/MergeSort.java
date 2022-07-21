package ca.jrvs.apps.practice.sorting;

public class MergeSort {
    public static void mergeSort(int[] arr){
        int len = arr.length;
        if (len < 2){
            return;
        }
        int mid = len / 2;
        int[] l = new int[mid];
        int[] r = new int[len - mid];

        for (int i = 0; i < mid; i++){
            l[i] = arr[i];
        }
        for (int i = mid; i < len; i++) {
            r[i - mid] = arr[i];
        }
        mergeSort(l);
        mergeSort(r);
        merge(arr, l, r, mid, len - mid);
    }

    public static void merge(int[]arr, int[] l, int[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right){
            if (l[i] <= r[j]){
                arr[k++] = l[i++];
            } else {
                arr[k++] = r[j++];
            }
        }
        while (i < left){
            arr[k++] = l[i++];
        }
        while (j < right){
            arr[k++] = r[j++];
        }
    }
}
