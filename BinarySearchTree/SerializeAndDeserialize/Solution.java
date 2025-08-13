package BinarySearchTree.SerializeAndDeserialize;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

import BinarySearchTree.TreeNode;

public class Solution {
    static void printTree(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode front = queue.poll();
            if (front == null) System.out.print("-1 ");
            else {
                System.out.print(front.val + " ");
                queue.offer(front.left);
                queue.offer(front.right);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the nodes of the binary tree (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.createTree(values, 0, values.length);

        String coded = Codec.serialize(root);
        System.out.println(coded);
        TreeNode node = Codec.deserialize(coded);

        printTree(node);
    }
}
