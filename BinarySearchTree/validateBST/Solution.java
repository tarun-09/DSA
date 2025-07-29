package BinarySearchTree.validateBST;

import java.util.Scanner;

import BinarySearchTree.TreeNode;

public class Solution {
    static boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    static boolean isValidBST(TreeNode root, long min, long max) {
        if (root == null) return true;

        long val = (long) root.val;

        if (val < min || val > max) return false;

        return isValidBST(root.left, min, val-1) && isValidBST(root.right, val + 1, max);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the BST nodes (space-seperated): ");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.createTree(values, 0, values.length);
        boolean result = isValidBST(root);
        System.out.println("The above tree is a valid BST: " + result);
    }
}
