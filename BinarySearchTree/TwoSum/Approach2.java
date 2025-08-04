package BinarySearchTree.TwoSum;

import BinarySearchTree.TreeNode;

public class Approach2 {
    public static boolean findTarget(TreeNode root, int target) {
        return findTargetWithSearch(root, root, target);
    }

    static boolean findTargetWithSearch(TreeNode root, TreeNode current, int target) {
        if (current == null) return false;

        int complement = target - current.val;
        if (search(root, current, complement)) return true;

        return findTargetWithSearch(root, current.left, target) || findTargetWithSearch(root, current.right, target);
    }

    static boolean search(TreeNode root, TreeNode temp, int complement) {
        if (root == null) return false;
        TreeNode curr = root;
        
        while (curr != null) {
            if (complement == curr.val && curr != temp) return true;
            else if (curr.val < complement) curr = curr.right;
            else curr = curr.left;
        }

        return false;
    }
}
