package PreOrderInOrderPostOrderInSingleTraversal;

public class StackElement {
    int state;
    TreeNode node;

    StackElement(int state, TreeNode node) {
        this.state = state;
        this.node = node;
    }
}
