package Heap.MinHeap;

public class Solution {
    public static void main(String[] args) {
        MinHeap minHeap = new MinHeap(5);

        minHeap.insert(15);
        minHeap.insert(10);
        minHeap.insert(12);
        minHeap.insert(20);
        minHeap.extractMinElement();
        minHeap.print();
    }
}
