import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoundaryTraversal {

    static boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }

    static void addLeftBoundary(TreeNode node, List<Integer> list) {
        TreeNode curr = node.left;

        while (curr != null) {
            if (!isLeaf(curr)) list.add(curr.val);

            if (curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    static void addLeaves(TreeNode node, List<Integer> list) {
        if (isLeaf(node)) list.add(node.val);

        if (node.left != null) addLeaves(node.left, list);
        if (node.right != null) addLeaves(node.right, list);
    }

    static void addRightBoundary(TreeNode node, List<Integer> list) {
        TreeNode curr = node.right;
        List<Integer> temp = new ArrayList<>();

        while (curr != null) {
            if (!isLeaf(curr)) temp.add(curr.val);

            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        for (int i=temp.size()-1; i>=0; i--) {
            list.add(temp.get(i));
        }
    }

    static List<Integer> traverseBoundary(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;

        if(!isLeaf(root)) list.add(root.val);

        addLeftBoundary(root, list);
        addLeaves(root, list);
        addRightBoundary(root, list);

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the tree nodes (space-seperated): ");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);
        List<Integer> list = traverseBoundary(root);

        for (int val : list) {
            System.out.print(val + " ");
        }

    }
}
