import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FlattenBinaryTree {

    static void flattenTree(TreeNode root) {
        TreeNode curr = root;

        while (curr != null) {
            if (curr.left == null)
                curr = curr.right;
            else {
                TreeNode prev = curr.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                prev.right = curr.right;
                curr.right = curr.left;
                curr.left = null;
                curr = curr.right;
            }
        }
    }

    static List<List<Integer>> traverse(TreeNode curr, int level, List<List<Integer>> list) {
        if (curr == null)
            return list;

        if (list.size() == level)
            list.add(new ArrayList<>());

        list.get(level).add(curr.val);

        traverse(curr.left, level + 1, list);
        traverse(curr.right, level + 1, list);

        return list;
    }

    static List<List<Integer>> levelOrderTraversal(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        if (root == null)
            return list;

        return traverse(root, 0, list);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the values of the tree nodes (space-seperated):");
        String input = sc.nextLine();
        String[] values = input.split(" ");
        sc.close();

        TreeNode root = TreeNode.insertIntoBinaryTree(values, 0, values.length);

        flattenTree(root);

        List<List<Integer>> list = levelOrderTraversal(root);

        for (List<Integer> level : list) {
            for (int val: level)
                System.out.print(val + " ");
            System.out.println();
        }

    }
}
