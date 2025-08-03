package BinarySearchTree.Floor;

import java.util.Scanner;

import BinarySearchTree.TreeNode;

public class Solution {
    static int floor(TreeNode root, int key) {
        int floor = -1;

        while (root != null) {
            if (root.val == key) return root.val;

            if (root.val > key) root = root.left;
            else {
                floor = root.val;
                root = root.right;
            }
        }

        return floor;
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
        int result = floor(root,key);

        System.out.println("The floor value will be: " + result);
    }
}