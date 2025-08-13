package BinarySearchTree.SerializeAndDeserialize;

import java.util.LinkedList;
import java.util.Queue;

import BinarySearchTree.TreeNode;

public class Codec {
    // String - "1 2 3 # # 4 5 # # # #"

    // Encodes a tree to a single string.
    public static String serialize(TreeNode root) {
        if (root == null)
            return "";
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front == null) {
                sb.append("# ");
            } else {
                sb.append(front.val);
                sb.append(" ");
                queue.offer(front.left);
                queue.offer(front.right);
            }
        }
        String res = sb.toString();
        return res;
    }

    // Decodes your encoded data to tree.
    public static TreeNode deserialize(String data) {
        if (data == "") {
            return null;
        }
        String[] values = data.split(" ");
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        queue.offer(root);
        int idx = 1;
        while (!queue.isEmpty() && idx < values.length) {
            String leftVal = values[idx++];
            String rightVal = values[idx++];
            TreeNode front = queue.poll();
            if (!leftVal.equals("#")) {
                front.left = new TreeNode(Integer.parseInt(leftVal));
                queue.offer(front.left);
            }
            if (!rightVal.equals("#")) {
                front.right = new TreeNode(Integer.parseInt(rightVal));
                queue.offer(front.right);
            }
        }
        return root;
    }
}
