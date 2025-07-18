import java.util.Scanner;

public class SameTree {
    static boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values for the tree 1 nodes (space-separated): ");
        String input1 = sc.nextLine();
        System.out.println("Enter the values for the tree 2 nodes (space-separated): ");
        String input2 = sc.nextLine();

        String[] values1 = input1.split(" ");
        String[] values2 = input2.split(" ");

        TreeNode root1 = TreeNode.insertIntoBinaryTree(values1, 0, values1.length);
        TreeNode root2 = TreeNode.insertIntoBinaryTree(values2, 0, values2.length);

        boolean result = isSameTree(root1, root2);

        System.out.println("Both Trees are Same: " + result);
    }
}