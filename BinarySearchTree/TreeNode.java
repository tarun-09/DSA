package BinarySearchTree;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    public static TreeNode createTree(String[] values, int index, int n) {
        if (index >= n || Integer.parseInt(values[index]) == -1) return null;

        TreeNode root = new TreeNode(Integer.parseInt(values[index]));
        root.left = createTree(values, 2 * index + 1, n);
        root.right = createTree(values, 2 * index + 2, n);
        return root;
    }

    public static void printTree(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            System.out.print(front.val + " ");
            if (front.left != null) queue.offer(front.left);
            if (front.right != null) queue.offer(front.right);
        }
    }
}
