import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class MorrisPostOrder {
    static void morrisPostOrder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        
        TreeNode curr = root;

        while(curr != null) {
            if(curr.right == null) {
                list.add(curr.val);
                curr = curr.left;
            } else {
                TreeNode prev = curr.right;
                while(prev.left != null && prev.left != curr) {
                    prev = prev.left;
                }

                if(prev.left == null) {
                    list.add(curr.val);
                    prev.left = curr;
                    curr = curr.right;
                } else if (prev.left == curr) {
                    prev.left = null;
                    curr = curr.left;
                }
            }
        }

        Collections.reverse(list);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values for the tree nodes (space-separated): ");
        String input = scanner.nextLine();
        String[] values = input.split(" ");
        scanner.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);

        List<Integer> list = new ArrayList<>();
        
        morrisPostOrder(root, list);

        for(Integer val: list) {
            System.out.print(val + " ");
        }
    }
}
