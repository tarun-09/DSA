package Heap.MaxHeap;

public class Solution {
    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.insert(20);
        maxHeap.insert(25);
        maxHeap.insert(10);
        maxHeap.insert(35);
        // maxHeap.extractMaxElement();
        maxHeap.print();
    }
}
