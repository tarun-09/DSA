package Heap.KthLargestInStream;

import java.util.PriorityQueue;

public class KthLargest {
    int k;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (int i = 0; i < nums.length; i++) {
            insertIntoHeap(nums[i]);
        }
    }

    public int add(int val) {
        insertIntoHeap(val);
        return minHeap.peek();
    }

    void insertIntoHeap(int val) {
        if (minHeap.size() < this.k) {
            minHeap.offer(val);
        } else if (val > minHeap.peek()) {
            minHeap.poll();
            minHeap.offer(val);
        }
    }
}
