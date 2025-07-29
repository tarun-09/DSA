package BinarySearchTree.PredecessorAndSuccessorForInorder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import BinarySearchTree.TreeNode;

public class Solution {
    static List<Integer> predecessorSuccessor(TreeNode root, int key) {
        TreeNode curr = root;
        TreeNode pred = null;
        TreeNode succ = null;

        while (curr != null) {
            if (key < curr.val) {
                succ = curr;
                curr = curr.left;
            } else if (key > curr.val) {
                pred = curr;
                curr = curr.right;
            } else {
                if (curr.left != null) {
                    TreeNode temp = curr.left;
                    while (temp.right != null)
                        temp = temp.right;
                    pred = temp;
                }

                if (curr.right != null) {
                    TreeNode temp = curr.right;
                    while (temp.left != null)
                        temp = temp.left;
                    succ = temp;
                }

                break;
            }
        }

        List<Integer> list = new ArrayList<>();

        if (pred != null)
            list.add(pred.val);
        else
            list.add(-1);

        if (succ != null)
            list.add(succ.val);
        else
            list.add(-1);

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the BST nodes (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        System.out.println("Enter the key: ");
        int k = sc.nextInt();
        sc.close();

        TreeNode root = TreeNode.createTree(values, 0, values.length);
        List<Integer> list = predecessorSuccessor(root, k);
<<<<<<< HEAD

        for (int val : list) {
=======
        
        for(int val: list) {
>>>>>>> af6201ee3e5ba8b4c41a576c64ab085a32ab6311
            System.out.print(val + " ");
        }
    }
}
