package VerticalOrderTraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static List<List<Integer>> verticalOrderTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        Map<Integer,HashMap<Integer,List<Integer>>> map = new HashMap<>();
        Queue<QueueElement> queue = new LinkedList<>();

        queue.offer(new QueueElement(0, 0, root));

        while (!queue.isEmpty()) {
            QueueElement front = queue.poll();
            int x = front.x;
            int y = front.y;
            TreeNode node = front.node;

            map.computeIfAbsent(x,k-> new HashMap<>())
            .computeIfAbsent(y, k-> new ArrayList<>())
            .add(node.val);

            if (node.left != null) {
                queue.offer(new QueueElement(x - 1, y + 1, node.left));
            }

            if (node.right != null) {
                queue.offer(new QueueElement(x + 1, y + 1, node.right));
            }
        }

        // Sort the map on the basis of x, then y, and then sort the list inside and return the list on the basis of x
        List<Integer> sortedX = new ArrayList<>(map.keySet());
        Collections.sort(sortedX);

        for (int x: sortedX) {
            Map<Integer, List<Integer>> yMap = map.get(x);
            List<Integer> sortedY = new ArrayList<>(yMap.keySet());
            Collections.sort(sortedY);

            List<Integer> vertical = new ArrayList<>();
            for (int y: sortedY) {
                List<Integer> nodes = yMap.get(y);
                Collections.sort(nodes);
                vertical.addAll(nodes);
            }
            list.add(vertical);
        }
        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();
        
        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);

        List<List<Integer>> lists = verticalOrderTraversal(root);

        for(List<Integer> list: lists) {
            for(int val: list) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
