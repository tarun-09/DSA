package Heap.KthLargestElement;

import java.util.PriorityQueue;

public class Approach2 {
    public static int kthLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int elem : arr) {
            minHeap.add(elem);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }

        return minHeap.peek();
    }
}
