package BinarySearchTree.PopulatingNextRightPointers;

import java.util.LinkedList;
import java.util.Queue;

public class Node {
    int val;
    Node left;
    Node right;
    Node next;

    Node(int val) {
        this.val = val;
    }

    // create binary tree
    public static Node createTree(String[] values, int index, int n) {
        if (index >= n || Integer.parseInt(values[index]) == -1) return null;

        Node root = new Node(Integer.parseInt(values[index]));
        root.left = createTree(values, 2 * index + 1, n);
        root.right = createTree(values, 2 * index + 2, n);
        return root;
    }

    public static void printTree(Node root) {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()) {
            Node front = queue.poll();
            System.out.print(front.val + " ");
            if (front.next == null) System.out.print("# ");
            if (front.left != null) queue.offer(front.left);
            if (front.right != null) queue.offer(front.right);
        }
    }
}
