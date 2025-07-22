import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreefromInorderAndPreOrder {
    static int i;
    static int p;

    static TreeNode buildTree(int[] inorder, int[] preorder) {
        return buildTree(inorder, preorder, Integer.MIN_VALUE);
    }

    static TreeNode buildTree(int[] inorder, int[] preorder, int stop) {
        if (p >= preorder.length)
            return null;

        if (inorder[i] == stop) {
            ++i;
            return null;
        }

        TreeNode root = new TreeNode(preorder[p++]);
        root.left = buildTree(inorder, preorder, root.val);
        root.right = buildTree(inorder, preorder, stop);

        return root;
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
        System.out.println("Enter the inorder traversal of the tree (space-seperated):");
        String in = sc.nextLine();
        System.out.println("Enter the preorder traversal of the tree (space-seperated):");
        String pre = sc.nextLine();
        sc.close();

        String[] inarray = in.split(" ");
        String[] prearray = pre.split(" ");

        int[] inorder = new int[inarray.length];
        int[] preorder = new int[prearray.length];

        for (int i = 0; i < inarray.length; i++) {
            inorder[i] = Integer.parseInt(inarray[i]);
            preorder[i] = Integer.parseInt(prearray[i]);
        }

        TreeNode root = buildTree(inorder, preorder);
        List<List<Integer>> list = levelOrderTraversal(root);
        for(List<Integer> level: list) {
            for(int val: level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
