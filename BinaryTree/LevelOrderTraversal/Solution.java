package LevelOrderTraversal;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        Queue<QueueElement> queue = new LinkedList<>();
        queue.offer(new QueueElement(0, root));

        while (!queue.isEmpty()) {
            QueueElement front = queue.poll();

            if (list.size() > front.level && list.get(front.level) != null) {
                list.get(front.level).add(front.node.val);
            } else {
                List<Integer> levelList = new ArrayList<>();
                levelList.add(front.node.val);
                list.add(levelList);
            }

            if (front.node.left != null) queue.offer(new QueueElement(front.level + 1, front.node.left));
            if (front.node.right != null) queue.offer(new QueueElement(front.level + 1, front.node.right));
        }

        return list;
    }

    static List<List<Integer>> traverse(TreeNode curr, int level, List<List<Integer>> list) {
        if (curr == null) return list;

        if (list.size() == level) list.add(new ArrayList<>());

        list.get(level).add(curr.val);

        traverse(curr.left, level + 1, list);
        traverse(curr.right, level + 1, list);

        return list;    
    }

    static List<List<Integer>> levelOrderTraversal1(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        return traverse(root, 0, list);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the tree (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split( " ");
        sc.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);
        // List<List<Integer>> list = levelOrderTraversal(root);
        List<List<Integer>> list = levelOrderTraversal1(root);

        for(List<Integer> level: list) {
            for (int val: level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
