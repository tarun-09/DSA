package BinarySearchTree.PopulatingNextRightPointers;

import java.util.LinkedList;
import java.util.Queue;

public class Approach1 {
    // Using Level Order Traversal
    protected static Node connect(Node root) {
        if (root == null) return null;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node prev = null;
            int len = queue.size();

            for (int i=0; i< len; i++) {
                Node front = queue.poll();
                if (prev != null) prev.next = front;
                prev = front;

                if (front.left != null) queue.offer(front.left);
                if (front.right != null) queue.offer(front.right);
            }
        }
        return root;
    }
}
