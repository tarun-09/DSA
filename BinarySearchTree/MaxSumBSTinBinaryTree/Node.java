package BinarySearchTree.MaxSumBSTinBinaryTree;

public class Node {
    public int sum;
    public int min;
    public int max;
    public boolean isBST;

    Node(int sum, int min, int max, boolean isBST) {
        this.sum = sum;
        this.min = min;
        this.max = max;
        this.isBST = isBST;
    }
}
