import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class PostOrder {
    public static void postOrder(TreeNode root, List<Integer> result) {
        if(root == null) {
            return;
        }
        postOrder(root.left, result);
        postOrder(root.right, result);
        result.add(root.val);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the values for the tree nodes (space-separated): ");
        String input = scanner.nextLine();
        String[] values = input.split(" ");
        
        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);

        List<Integer> result = new ArrayList<>();
        postOrder(root, result);

        System.out.println("Post-order traversal of the binary tree:");
        for (Integer val : result) {
            System.out.print(val + " ");
        }

    }
}