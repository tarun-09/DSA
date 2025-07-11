import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class PreOrder {
    public static void preOrder(TreeNode root, List<Integer> result) {

        // Base case: if the root is null, return an empty list
        if (root == null) {
            return;
        }

        result.add(root.val);

        preOrder(root.left, result);
        preOrder(root.right, result);
    }

    public static void main(String[] args) {
        
        // Take an array as input from console
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the values for the tree nodes (space-separated):");
        String input = scanner.nextLine();
        String[] values = input.split(" ");
        scanner.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);

        List<Integer> result = new ArrayList<>();
        preOrder(root, result);

        // Print the pre-order traversal result
        System.out.println("Pre-order traversal of the binary tree:");
        for (Integer val : result) {
            System.out.print(val + " ");
        }
    }



}