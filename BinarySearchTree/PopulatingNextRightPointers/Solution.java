package BinarySearchTree.PopulatingNextRightPointers;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the tree nodes (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");

        Node root = Node.createTree(values, 0, values.length);
        Node newRoot = Approach2.connect(root);

        System.out.println("Result after populating next pointers: ");
        Node.printTree(newRoot);
    }
}
