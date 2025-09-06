package Graph.DetectCycleinUndirectedGraph;

import java.util.ArrayList;

public class DFS {
    public static boolean detectCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = ConstructAdj.contructAdj(V, edges);
        int[] visited = new int[V];

        for (int i = 0; i < V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited, -1))
                    return true;
            }
        }
        return false;
    }

    public static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int parent) {
        visited[node] = 1;
        for (int neighbour : adj.get(node)) {
            if (visited[neighbour] == 0) {
                if (dfs(neighbour, adj, visited, node))
                    return true;
            } else if (neighbour != parent) {
                return true;
            }
        }
        return false;
    }
}
