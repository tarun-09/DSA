package Heap.MergeKSortedArrays;

public class Node implements Comparable<Node> {
    int i;
    int j;
    int val;

    Node(int i, int j, int val) {
        this.i = i;
        this.j = j;
        this.val = val;
    }

    public int compareTo(Node other) {
        return Integer.compare(this.val, other.val);
    }
}
