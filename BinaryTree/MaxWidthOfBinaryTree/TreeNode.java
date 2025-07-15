package MaxWidthOfBinaryTree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    static TreeNode insertIntoBinaryTree(String[] values, int index, int n) {
        if(index >= n || Integer.parseInt(values[index]) == -1) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(values[index]));
        root.left = insertIntoBinaryTree(values, 2 * index + 1, n);
        root.right = insertIntoBinaryTree(values, 2 * index + 2, n);
        return root;
    }
}
