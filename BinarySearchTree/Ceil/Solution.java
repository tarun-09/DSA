package BinarySearchTree.Ceil;

import java.util.Scanner;

import BinarySearchTree.TreeNode;

public class Solution {
    static int ceil(TreeNode root, int key) {
        int ceil = -1;

        while (root != null) {
            if (root.val == key) return root.val;

            if (root.val < key) root = root.right;
            else {
                ceil = root.val;
                root = root.left;
            }
        }

        return ceil;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the BST node's (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        System.out.println("Enter the key: ");
        int key = sc.nextInt();
        sc.close();

        TreeNode root = TreeNode.createTree(values, 0, values.length);
        int result = ceil(root,key);

        System.out.println("The ceil value will be: " + result);
    }
}
