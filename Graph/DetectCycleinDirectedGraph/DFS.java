package Graph.DetectCycleinDirectedGraph;

import java.util.ArrayList;

public class DFS {
    public static boolean detectCycle(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];

            adj.get(u).add(v);
        }

        int[] visited = new int[V];
        int[] recStack = new int[V];    

        for(int i=0; i<V; i++) {
            if (visited[i] == 0) {
                if (dfs(i, adj, visited, recStack))
                    return true;
            }
        }

        return false;
    }

    private static boolean dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, int[] recStack) {
        visited[node] = 1;
        recStack[node] = 1;

        for (int neighbour : adj.get(node)) {
            if (visited[neighbour] == 0) {
                if (dfs(neighbour, adj, visited, recStack))
                    return true;
            } else if (recStack[neighbour] == 1) {
                return true;
            }
        }

        recStack[node] = 0;
        return false;
    }

}
