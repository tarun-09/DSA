import java.util.Scanner;

public class MaxPathSum {
    static int maxSum = Integer.MIN_VALUE;
    static int maxPathSum(TreeNode root) {
        maxPath(root);
        return maxSum;
    }

    static int maxPath(TreeNode root) {
        if (root == null) return 0;

        int leftPathSum = Math.max(0, maxPath(root.left));
        int rightPathSum = Math.max(0, maxPath(root.right));

        maxSum = Math.max(maxSum, root.val + leftPathSum + rightPathSum);

        return root.val + Math.max(leftPathSum, rightPathSum);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the tree nodes (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);
        int sum = maxPathSum(root);

        System.out.println("Max Path Sum of the Binary Tree: " + sum);
    }
}