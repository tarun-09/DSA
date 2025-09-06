package Graph.DetectCycleinUndirectedGraph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static boolean detectCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = ConstructAdj.contructAdj(V, edges);
        int[] visited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (bfs(i, adj, visited))
                    return true;
            }
        }

        return false;
    }

    public static boolean bfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] { node, -1 });
        visited[node] = 1;

        while (!q.isEmpty()) {
            int[] front = q.poll();
            int fNode = front[0];
            int fParent = front[1];

            for (int neighbour : adj.get(fNode)) {
                if (visited[neighbour] == 0) {
                    visited[neighbour] = 1;
                    q.offer(new int[] { neighbour, fNode });
                } else if (neighbour != fParent) {
                    return true;
                }
            }
        }
        return false;
    }
}
