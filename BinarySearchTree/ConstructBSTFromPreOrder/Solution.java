package BinarySearchTree.ConstructBSTFromPreOrder;

import java.util.Scanner;

import BinarySearchTree.TreeNode;

public class Solution {
    static TreeNode constructBSTFromPreorder(int[] nums) {
        if (nums.length == 0) return null;
        return recursiveBSTfromPreorder(nums, 0, nums.length - 1);
    }

    static TreeNode recursiveBSTfromPreorder(int[] nums, int start, int end) {
        if (start > end) return null;
        TreeNode root = new TreeNode(nums[start]);
        if (start == end) return root;

        int i = start;
        while(i < end && nums[i + 1] < root.val) {
            ++i;
        }

        root.left = recursiveBSTfromPreorder(nums, start + 1, i);
        root.right = recursiveBSTfromPreorder(nums, i + 1, end);
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the preorder travesal of the Tree (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        int[] nums = new int[values.length];
        for(int i=0; i<values.length; i++) {
            nums[i] = Integer.parseInt(values[i]);
        }

        TreeNode root = constructBSTFromPreorder(nums);
        System.out.println("BST from the preorder traversal");
        TreeNode.printTree(root);
    }
}
