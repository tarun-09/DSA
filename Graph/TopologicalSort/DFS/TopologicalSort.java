package Graph.TopologicalSort.DFS;
import java.util.ArrayList;
import java.util.Stack;

public class TopologicalSort {
    public static ArrayList<Integer> topologicalSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0; i<V; i++) {
            adj.add(new ArrayList<>());
        }

        for(int[] edge: edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[V];

        for(int i=0; i<V; i++) {
            if(visited[i] == 0) {
                dfs(i, adj, visited, stack);
            }
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!stack.isEmpty()) {
            result.add(stack.pop());
        }

        return result;
    }

    private static void dfs(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, Stack<Integer> stack) {
        visited[node] = 1;

        for(int neighbour: adj.get(node)) {
            if(visited[neighbour] == 0) {
                dfs(neighbour, adj, visited, stack);
            }
        }

        stack.push(node);
    }
}
