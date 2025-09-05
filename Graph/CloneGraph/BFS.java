package Graph.CloneGraph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static Node cloneGraph(Node node) {
        if (node == null)
            return null;

        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Node> copies = new HashMap<>();

        Node clone = new Node(node.val);
        copies.put(node, clone);
        q.offer(node);

        while (!q.isEmpty()) {
            Node front = q.poll();

            for(Node neighbor: front.neighbors) {
                if (!copies.containsKey(neighbor)) {
                    copies.put(neighbor, new Node(neighbor.val));
                    q.offer(neighbor);
                }

                copies.get(front).neighbors.add(copies.get(neighbor));
            }
        }
        return copies.get(node);
    }
}
