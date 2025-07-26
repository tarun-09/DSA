package BinarySearchTree.PopulatingNextRightPointers;

public class Approach2 {
    // Using Controlled Recusion - vertical recusrsion along with level recursion
    protected static Node connect(Node root) {
        if (root == null || root.left == null) return root;
        Node leftMost = root;
        connnectChildren(leftMost);
        connect(leftMost.left);
        return root;
    }

    static void connnectChildren(Node node) {
        if (node == null) return;
        node.left.next = node.right;

        if (node.next != null) node.right.next = node.next.left;
        connnectChildren(node.next);
    }
}
