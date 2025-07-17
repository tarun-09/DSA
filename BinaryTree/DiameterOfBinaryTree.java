import java.util.Scanner;

public class DiameterOfBinaryTree {
    static int diameter(TreeNode root) {
        if (root == null) return 0;

        int[] diameter = new int[1];
        diameter[0] = 0;
        height(root, diameter);
        return diameter[0];
    }

    static int height(TreeNode node, int[] diameter) {
        if (node == null) return 0;
        int left = height(node.left, diameter);
        int right = height(node.right, diameter);

        diameter[0] = Math.max(diameter[0], left + right);

        return 1 + Math.max(left, right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the tree nodes (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);

        int diameter = diameter(root);

        System.out.println("Diameter of the Binary Tree: " + diameter);
    }
}
