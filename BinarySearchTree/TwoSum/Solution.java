package BinarySearchTree.TwoSum;

import java.util.Scanner;

import BinarySearchTree.TreeNode;

public class Solution {

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of BST node's (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        System.out.println("Enter the value of target sum:");
        int target = sc.nextInt();
        sc.close();

        TreeNode root = TreeNode.createTree(values, 0, values.length);
        // boolean result = Approach1.findTarget(root, target);
        boolean result = Approach2.findTarget(root, target);

        System.out.println("The pair found with the target: " + result);
     }
}