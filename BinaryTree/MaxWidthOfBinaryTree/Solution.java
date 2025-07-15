package MaxWidthOfBinaryTree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    public static int maxWidth(TreeNode root) {
        if (root == null) return 0;

        Queue<QueueElement> queue = new LinkedList<>();
        int ans = 0;
        queue.offer(new QueueElement(0, root));

        while(!queue.isEmpty()) {
            int size = queue.size();
            int minIdx = queue.peek().index;
            int first = 0, last = 0;

            for(int i=0; i<size; i++) {
                QueueElement front = queue.poll();
                int index = front.index;
                int normalizedIdx = index - minIdx;

                if (i == 0) first = normalizedIdx;
                if (i == size-1) last = normalizedIdx;

                if (front.node.left != null) queue.offer(new QueueElement(2 * index + 1 , front.node.left)); 
                if (front.node.right != null) queue.offer(new QueueElement(2 * index + 2, front.node.right));
            }

            ans = Math.max(ans, last - first + 1);
        }

        return ans;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the tree nodes (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);
        int width = maxWidth(root);
        System.out.println("Max Width: " + width);
    }
}
