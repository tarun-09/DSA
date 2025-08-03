package BinarySearchTree.KthLargest;

import java.util.Scanner;

import BinarySearchTree.TreeNode;

public class Solution {
    static int kthLargest(TreeNode root, int k) {
        int count = 0;
        TreeNode curr = root;

        while (curr != null) {
            if (curr.right == null) {
                count++;
                if (count == k) return curr.val;
                curr = curr.left;
            } else {
                TreeNode prev = curr.right;
                while (prev.left != null && prev.left != curr) {
                    prev = prev.left;
                }

                if (prev.left == null) {
                    prev.left = curr;
                    curr = curr.right;
                } else {
                    prev.left = null;
                    count++;
                    if (count == k) return curr.val;
                    curr = curr.left;
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
        int result = kthLargest(root, k);
        System.out.println("The Kth largest value will be: "+ result);
    }
}
