package Heap.KthLargestElement;

public class Approach3 {
    public static int kthLargestElement(int[] arr, int k) {
        // considering range 10^-5 to 10^5
        int[] range = new int[200010];

        for (int elem : arr) {
            range[elem + 100000]++;
        }

        int count = 0;
        for (int i = range.length - 1; i > 0; i--) {
            count += range[i];

            if (count >= k) {
                return i - 100000;
            }
        }

        return -1;
    }
}
