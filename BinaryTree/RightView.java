import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class RightView {
    // Approach 1 - recursive approach
    static void rightView(TreeNode curr, int level, List<Integer> list) {
        if (curr == null) {
            return;
        }

        if (level == list.size()){
            list.add(curr.val);
        }

        rightView(curr.right, level+1, list);
        rightView(curr.left, level+1, list);
    }

    // Approach 2 - level order traversal
    static List<Integer> rightViewLevelOrder(TreeNode root) {
        List<Integer> list = new ArrayList<>();

        if(root == null) {
            return list;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int len = queue.size();
            for(int i=0; i<len; i++) {
                TreeNode front = queue.poll();

                if (i == 0) {
                    list.add(front.val);
                }

                if (front.right != null) {
                    queue.offer(front.right);
                }

                if (front.left != null) {
                    queue.offer(front.left);
                }
            }
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
        // List<Integer> list = new ArrayList<>();
        // rightView(root, 0, list);

        List<Integer> list = rightViewLevelOrder(root);

        for(Integer val : list) {
            System.out.print(val + " ");
        }
    }
}
