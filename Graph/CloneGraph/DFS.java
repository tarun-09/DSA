package Graph.CloneGraph;

import java.util.HashMap;

public class DFS {
    static HashMap<Node, Node> copies = new HashMap<>();

    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;

        if (!copies.containsKey(node)) {
            Node clone = new Node(node.val);
            copies.put(node, clone);

            for (Node neighbor : node.neighbors) {
                clone.neighbors.add(cloneGraph(neighbor));
            }
        }
        return copies.get(node);
    }
}
