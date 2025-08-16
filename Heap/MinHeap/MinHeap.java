package Heap.MinHeap;

public class MinHeap {
    int[] heap;
    int size;
    int curr;

    public MinHeap(int size) {
        this.size = size;
        this.curr = 0;
        heap = new int[this.size];
    }

    void insert(int val) {
        if (curr >= size)
            return;

        heap[curr] = val;
        int x = curr;
        curr++;

        while (heap[x] < heap[parent(x)]) {
            swap(x, parent(x));
            x = parent(x);
        }
    }

    int extractMinElement() {
        if (curr <= 0)
            return -1;
        int elem = heap[0];
        heap[0] = heap[--curr];
        heapify(0);
        return elem;
    }

    void heapify(int pos) {
        int min = pos;
        if (left(pos) < curr && heap[left(pos)] < heap[min]) {
            min = left(pos);
        }
        if (right(pos) < curr && heap[right(pos)] < heap[min]) {
            min = right(pos);
        }
        if (min != pos) {
            swap(pos, min);
            heapify(min);
        }
    }

    // helper functions
    int parent(int pos) {
        return (pos - 1) / 2;
    }

    int left(int pos) {
        return 2 * pos + 1;
    }

    int right(int pos) {
        return 2 * pos + 2;
    }

    void swap(int pos1, int pos2) {
        int temp = heap[pos1];
        heap[pos1] = heap[pos2];
        heap[pos2] = temp;
    }

    boolean isLeaf(int pos) {
        return (2 * pos + 1 >= curr);
    }

    void print() {
        for(int i=0; i<curr; i++) {
            System.out.print(heap[i] + " ");
        }
    }
}
