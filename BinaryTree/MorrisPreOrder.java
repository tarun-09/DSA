import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class MorrisPreOrder {
    static void morrisPreOrder(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }

        TreeNode curr = root;

        while(curr != null) {
            if(curr.left == null) {
                list.add(curr.val);
                curr = curr.right;
            } else {
                TreeNode prev = curr.left;
                while(prev.right != null && prev.right != curr) {
                    prev = prev.right;
                }

                if(prev.right == null) {
                    list.add(curr.val);
                    prev.right = curr;
                    curr = curr.left;
                } else if (prev.right == curr) {
                    prev.right = null;
                    curr = curr.right;
                }
            }
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values for the tree nodes (space-separated): ");
        String input = scanner.nextLine();
        String[] values = input.split(" ");
        scanner.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);

        List<Integer> list = new ArrayList<>();

        morrisPreOrder(root, list);

        for(Integer val: list) {
            System.out.print(val + " ");
        }
    }
}
