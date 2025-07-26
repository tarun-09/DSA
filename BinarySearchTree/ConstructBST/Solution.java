package BinarySearchTree.ConstructBST;
import java.util.Scanner;
import BinarySearchTree.TreeNode;

public class Solution {
    static TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length -1);
    }

    static TreeNode constructBST(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = constructBST(nums, start, mid - 1);
        root.right = constructBST(nums, mid + 1, end);
        return root;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the sorted values to construct BST (space seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        int[] nums = new int[values.length];
        for(int i=0; i<values.length; i++) {
            nums[i] = Integer.parseInt(values[i]);
        }

        TreeNode root = sortedArrayToBST(nums);
        System.out.println("Binary Search Tree will be: ");
        TreeNode.printTree(root);
    }
}
