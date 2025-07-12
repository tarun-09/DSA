package BottomView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class BottomView {
    static List<Integer> bottomView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }

        Queue<QueueElement> queue = new LinkedList<>();
        Map<Integer, Integer> map = new HashMap<>();

        queue.offer(new QueueElement(0, root));

        while (!queue.isEmpty()) {
            QueueElement front = queue.poll();

            map.put(front.position, front.node.val);

            if (front.node.left != null) {
                queue.offer(new QueueElement(front.position - 1, front.node.left));
            }

            if (front.node.right != null) {
                queue.offer(new QueueElement(front.position + 1, front.node.right)); 
            }
        }

        // Sort the map and make the list
        List<Integer> keys = new ArrayList<>(map.keySet());
        Collections.sort(keys);
        for(int key: keys) {
            System.out.println(key + "  " + map.get(key));
            list.add(map.get(key));
        }

        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values for the tree nodes (space-separated): ");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);
        
        List<Integer> list = bottomView(root);

        for(Integer val: list) {
            System.out.print(val + " ");
        }
    }
}
