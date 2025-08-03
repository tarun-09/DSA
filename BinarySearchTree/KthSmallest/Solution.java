package BinarySearchTree.KthSmallest;

import java.util.Scanner;

import BinarySearchTree.TreeNode;

public class Solution {
    static int kthSmallest(TreeNode root, int k) {
        int count = 0;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {
                count++;
                if (count == k) return curr.val;
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
                    count++;
                    if (count == k) return curr.val;
                    curr = curr.right;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the BST nodes (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        System.out.println("Enter the value of K: ");
        int k = sc.nextInt();
        sc.close();

        TreeNode root = TreeNode.createTree(values, 0, values.length);
        int result = kthSmallest(root, k);
        System.out.println("The Kth smallest value will be: "+ result);
    }
}
