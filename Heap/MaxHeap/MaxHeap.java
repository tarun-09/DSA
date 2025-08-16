package Heap.MaxHeap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MaxHeap {
    List<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    void insert(int val) {
        heap.add(val);
        int curr = heap.size() - 1;
        while (curr > 0 && heap.get(curr) > heap.get(parent(curr))) {
            Collections.swap(heap, curr, parent(curr));
            curr = parent(curr);
        }
    }

    int extractMaxElement() {
        if (heap.isEmpty())
            return -1;
        
        int max = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        heap.set(0, last);
        heapify(0);

        return max;
    }

    void heapify(int pos) {
        int left = 2 * pos + 1;
        int right = 2 * pos + 2;
        int max = pos;

        if (left < heap.size() && heap.get(left) > heap.get(max) ){
            max = left;
        }
        if (right < heap.size() && heap.get(right) > heap.get(max) ){
            max = right;
        }

        if (max != pos) {
            Collections.swap(heap, pos, max);
            heapify(max);
        }
    }

    int parent(int pos) {
        return (pos - 1) / 2;
    }

    void print (){
        for(int elem: heap) {
            System.out.print(elem + " ");
        }
    }
}
