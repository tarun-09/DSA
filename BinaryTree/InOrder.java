import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class InOrder {
    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values for the tree nodes (space-separated): ");
        String input = scanner.nextLine();
        String[] values = input.split(" ");

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);

        List<Integer> list = new ArrayList<>();
        inOrder(root, list);

        System.out.println("In-order traversal of the binary tree:");
        
        for (Integer val : list) {
            System.out.print(val + " ");
        }
    }
}