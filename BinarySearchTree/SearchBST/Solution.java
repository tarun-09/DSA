package BinarySearchTree.SearchBST;

import java.util.Scanner;

import BinarySearchTree.TreeNode;

public class Solution {
    public static  TreeNode searchBST(TreeNode root, int key) {
        if (root == null || root.val == key) return root;

        TreeNode left = null;
        TreeNode right = null;

        if (key < root.val) left = searchBST(root.left, key);
        else right = searchBST(root.right, key);

        if (left != null) return left;
        if (right != null) return right;
        
        return null;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the tree nodes (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        System.out.println("Enter the key have to search: ");
        int key = sc.nextInt();
        sc.close();

        TreeNode root = TreeNode.createTree(values, 0, values.length);

        TreeNode node = searchBST(root, key);
        System.out.println("Output of the Search: ");
        TreeNode.printTree(node);
    }
}
