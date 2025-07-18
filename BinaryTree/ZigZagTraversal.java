import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ZigZagTraversal {
    static List<List<Integer>> traverse(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        boolean leftToRight = true;

        while (!queue.isEmpty()) {
            int len = queue.size();
            LinkedList<Integer> level = new LinkedList<>();

            for (int i=0; i<len; i++) {
                TreeNode front = queue.poll();

                if  (leftToRight) level.addLast(front.val);
                else level.addFirst(front.val);

                if (front.left != null) queue.offer(front.left);
                if (front.right != null) queue.offer(front.right);
            }
            leftToRight = !leftToRight;
            list.add(level);
        }

        return list;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the tree nodes (space-seperated): ");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);
        List<List<Integer>> list = traverse(root);

        for(List<Integer> level: list) {
            for(int val: level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
