package BinarySearchTree.BSTIterator;

import java.util.Scanner;

import BinarySearchTree.TreeNode;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of BST node's (space-seperated)");
        String input = sc.nextLine();
        String[] values = input.split(" ");

        System.out.println("Enter the commands for the BST Iterator");
        String input2 = sc.nextLine();
        String[] commands = input2.split(" ");
        sc.close();

        TreeNode root = TreeNode.createTree(values, 0, values.length);

        BSTIterator bstIterator = new BSTIterator(root);
        for (String command: commands) {
            if (command.equals("BSTIterator")) continue;
            if (command.equals("next")) System.out.print(bstIterator.next() + " ");
            if (command.equals("hasNext")) System.out.print(bstIterator.hasNext() + " ");
        }
    }
}
