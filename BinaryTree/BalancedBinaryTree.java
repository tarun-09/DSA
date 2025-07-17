import java.util.Scanner;

public class BalancedBinaryTree {
    static boolean isBalanced(TreeNode root) {
        if (root == null) return true;

        return height(root) != -1;
    }

    static int height(TreeNode node) {
        if (node == null) return 0;

        int left = height(node.left);
        if (left == -1) return -1;

        int right = height(node.right);
        if (right == -1) return -1;

        if (Math.abs(left - right) > 1) return -1;

        return 1 + Math.max(left, right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the tree nodes (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);

        boolean result = isBalanced(root);
        System.out.println("The input tree is a Balanced Tree: " + result);
    }
}