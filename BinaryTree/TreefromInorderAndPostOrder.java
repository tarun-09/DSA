import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TreefromInorderAndPostOrder {
    static int i;
    static int p;

    static TreeNode buildTree(int[] inorder, int[] postorder) {
        i = inorder.length - 1;
        p = postorder.length - 1;
        return buildTree(inorder, postorder, Integer.MIN_VALUE);
    }

    static TreeNode buildTree(int[] inorder, int[] postorder, int stop) {
        if (p < 0)
            return null;

        if (inorder[i] == stop) {
            --i;
            return null;
        }

        TreeNode root = new TreeNode(postorder[p--]);
        root.right = buildTree(inorder, postorder, root.val);
        root.left = buildTree(inorder, postorder, stop);

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
        System.out.println("Enter the postorder traversal of the tree (space-seperated):");
        String post = sc.nextLine();
        sc.close();

        String[] inarray = in.split(" ");
        String[] postarray = post.split(" ");

        int[] inorder = new int[inarray.length];
        int[] postorder = new int[postarray.length];

        for (int i = 0; i < inarray.length; i++) {
            inorder[i] = Integer.parseInt(inarray[i]);
            postorder[i] = Integer.parseInt(postarray[i]);
        }

        TreeNode root = buildTree(inorder, postorder);
        List<List<Integer>> list = levelOrderTraversal(root);
        for(List<Integer> level: list) {
            for(int val: level) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }
}
