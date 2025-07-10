class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }

    // Method to insert values into the binary tree from an array
    public static TreeNode insertIntoBinaryTree(String[] values, int index, int n) {
        if(index >= n || Integer.parseInt(values[index]) == -1 ) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[index]));
        node.left = insertIntoBinaryTree(values, 2 * index + 1, n);
        node.right = insertIntoBinaryTree(values, 2 * index + 2, n);
        System.out.println("Inserted node with value: " + node.val);
        System.out.println("Left child: " + (node.left != null ? node.left.val : "null"));
        System.out.println("Right child: " + (node.right != null ? node.right.val : "null"));
        return node;
    }
}
