package Heap.KthLargestElement;

import java.util.Arrays;

public class Approach1 {
    public static int kthLargestElement(int[] arr, int k) {
        Arrays.sort(arr);
        return arr[arr.length - k];
    }
}
