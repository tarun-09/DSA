package PreOrderInOrderPostOrderInSingleTraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class Solution {
    static List<List<Integer>> treeTraversal(TreeNode root) {
        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(preOrder);
        lists.add(inOrder);
        lists.add(postOrder);

        if (root == null) {
            return lists;
        }

        Stack<StackElement> stack = new Stack<>();
        stack.push(new StackElement(1, root));

        while (!stack.isEmpty()) {
            StackElement top = stack.pop();
            int state = top.state;
            TreeNode node = top.node;

            if (state == 1) {
                preOrder.add(node.val);
                stack.push(new StackElement(2, node));
                if (node.left != null) {
                    stack.push(new StackElement(1, node.left));
                }
            } else if (state == 2) {
                inOrder.add(node.val);
                stack.push(new StackElement(3, node));
                if(node.right != null) {
                    stack.push(new StackElement(1, node.right));
                }
            } else if (state == 3) {
                postOrder.add(node.val);
            }

        }

        return lists;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values for the tree nodes (space-separated): ");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);

        List<List<Integer>> lists = treeTraversal(root);

        for(List<Integer> list: lists) {
            for(int val: list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
