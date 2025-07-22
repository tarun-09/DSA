import java.util.Scanner;

public class ChildrenSumProperty {
    static boolean isParentSum(TreeNode root) {
        if (root == null) return true;

        if (root.left == null && root.right == null) return true;

        int sum = 0;
        if (root.left != null) sum += root.left.val;
        if (root.right != null) sum += root.right.val;

        return root.val == sum && isParentSum(root.left) &&  isParentSum(root.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the tree nodes (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);
        boolean result = isParentSum(root);

        System.out.println("The folowing tree fulfills children sum property: " + result);
    }
}
