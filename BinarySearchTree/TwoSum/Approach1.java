package BinarySearchTree.TwoSum;

import java.util.HashSet;
import java.util.Set;

import BinarySearchTree.TreeNode;

public class Approach1 {
    public static boolean findTarget(TreeNode root, int target) {
        Set<Integer> set = new HashSet<>();
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null) {
                if (set.contains(target - curr.val)) return true;
                set.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while (prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = curr;
                    curr = curr.left;
                } else {
                    prev.right = null;
                    if (set.contains(target - curr.val)) return true;
                    set.add(curr.val);
                    curr = curr.right;
                }
            }
        }

        return false;
    }
}
