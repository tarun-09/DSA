package BinarySearchTree.BSTIterator;

import java.util.ArrayList;
import java.util.List;

import BinarySearchTree.TreeNode;

public class BSTIterator {
    List<Integer> inorder = new ArrayList<>();
    int index = 0;

    public BSTIterator(TreeNode root) {
        inorder(root);
    }

    void inorder(TreeNode root) {
        if (root == null) return;
        inorder(root.left);
        inorder.add(root.val);
        inorder(root.right);
    }

    public int next() {
        return inorder.get(index++);
    }

    public boolean hasNext() {
        if (index < inorder.size()) return true;
        return false;
    }
    
}