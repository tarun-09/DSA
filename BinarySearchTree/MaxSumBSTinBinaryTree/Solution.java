package BinarySearchTree.MaxSumBSTinBinaryTree;

import java.util.Scanner;

import BinarySearchTree.TreeNode;

public class Solution {
    static int res = 0;
    static int maxSumBST(TreeNode root) {
        if (root == null) return 0;
        maxSum(root);
        return res;
    }

    static Node maxSum(TreeNode root) {
        if (root == null) return new Node(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);

        Node left = maxSum(root.left);
        Node right = maxSum(root.right);

        int sum = root.val + left.sum + right.sum;
        int min = Math.min(root.val, left.min);
        int max = Math.max(root.val, right.max);
        boolean isBST = left.isBST && right.isBST && left.max < root.val && root.val < right.min;
        Node node = new Node(sum, min, max, isBST);
        if (node.isBST) res = Math.max(res, node.sum);
        return node;
    }


     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the nodes of the binary tree (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.createTree(values, 0, values.length);
        int result = maxSumBST(root);
        System.out.println("The max sum BST is: " + result);
     }
}