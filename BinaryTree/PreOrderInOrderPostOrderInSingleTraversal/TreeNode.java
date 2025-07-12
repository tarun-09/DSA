package PreOrderInOrderPostOrderInSingleTraversal;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    // Method to insert values into the binary tree from an array
    static TreeNode insertIntoBinaryTree(String[] values, int index, int n) {
        if (index >= n || Integer.parseInt(values[index]) == -1) {
             return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[index]));
        node.left = insertIntoBinaryTree(values, 2 * index + 1, n);
        node.right = insertIntoBinaryTree(values, 2 * index + 2, n);
        return node;
    }
}
