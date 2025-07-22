import java.util.Scanner;

public class MirrorImage {
    public static boolean areMirrorImages(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) return root1 == root2;

        return root1.val == root2.val && areMirrorImages(root1.left, root2.right) && areMirrorImages(root1.right, root2.left);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the Tree 1 values (space-seperated):");
        String input1 = sc.nextLine();
        System.out.println("Enter the values of the Tree 2 values (space-seperated):");
        String input2 = sc.nextLine();
        sc.close();

        String[] values1 = input1.split(" ");
        String[] values2 = input2.split(" ");

        TreeNode root1 = TreeNode.insertIntoBinaryTree(values1, 0, values1.length);
        TreeNode root2 = TreeNode.insertIntoBinaryTree(values2, 0, values2.length);

        boolean result = areMirrorImages(root1, root2);

        System.out.println("The trees are mirror images: " + result);
    }
}
