import java.util.Scanner;

public class SymmetricTree extends MirrorImage {
    static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;

        return areMirrorImages(root.left, root.right);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the tree nodes (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);
        boolean result = isSymmetric(root);
        System.out.println("The tree is symmetric: " + result);
    }
}
