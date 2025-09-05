package Graph.CloneGraph;

import java.util.ArrayList;

public class Node {
    public int val;
    public ArrayList<Node> neighbors;

    Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }
}
