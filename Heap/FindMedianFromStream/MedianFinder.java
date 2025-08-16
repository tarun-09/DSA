package Heap.FindMedianFromStream;

import java.util.PriorityQueue;

public class MedianFinder {
    PriorityQueue<Integer> minHeap;
    PriorityQueue<Integer> maxHeap;

    public MedianFinder() {
        minHeap = new PriorityQueue<>();
        maxHeap = new PriorityQueue<>((a, b) -> b - a);
    }

    public void addNum(int num) {
        if (maxHeap.isEmpty() || num < maxHeap.peek()) {
            maxHeap.add(num);
        } else {
            minHeap.add(num);
        }

        if (Math.abs(minHeap.size() - maxHeap.size()) > 1) {
            if (minHeap.size() < maxHeap.size()) {
                minHeap.add(maxHeap.poll());
            } else {
                maxHeap.add(minHeap.poll());
            }
        }
    }

    public double findMedian() {
        double median;
        int a = minHeap.size();
        int b = maxHeap.size();

        if (a == b) {
            median = (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            if (a < b) {
                median = maxHeap.peek();
            } else {
                median = minHeap.peek();
            }
        }

        return median;
    }
}
