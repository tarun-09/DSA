package LevelOrderTraversal;

public class QueueElement {
    int level;
    TreeNode node;

    QueueElement(int level, TreeNode node) {
        this.level = level;
        this.node = node;
    }
}   
