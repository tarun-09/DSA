package BinarySearchTree.LCA;

import java.util.Scanner;

import BinarySearchTree.TreeNode;

public class Solution {
    static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || p.val == root.val || q.val == root.val ||
                (Math.min(p.val, q.val) < root.val && Math.max(p.val, q.val) > root.val))
            return root;

        if (p.val < root.val && q.val < root.val)
            return lowestCommonAncestor(root.left, p, q);

        return lowestCommonAncestor(root.right, p, q);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the BST nodes (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        System.out.println("Enter the values of p & q node (space-seperated):");
        int p = sc.nextInt();
        int q = sc.nextInt();
        sc.close();

        TreeNode root = TreeNode.createTree(values, 0, values.length);
        TreeNode x = new TreeNode(p);
        TreeNode y = new TreeNode(q);

        TreeNode result = lowestCommonAncestor(root, x, y);

        System.out.println("Lowest Common Ancestor of p & q is: " + result.val);
    }
}
