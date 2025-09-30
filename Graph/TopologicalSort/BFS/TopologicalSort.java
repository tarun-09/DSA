package Graph.TopologicalSort.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class TopologicalSort {
    public static ArrayList<Integer> topologicalSort(int V, int[][] edges) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
        }

        int[] inDegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int neighbour : adj.get(i)) {
                inDegree[neighbour]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < V; i++) {
            if(inDegree[i] == 0)
                q.offer(i);
        }

        ArrayList<Integer> result = new ArrayList<>();
        while(!q.isEmpty()) {
            int node = q.poll();
            result.add(node);

            for(int neighbour: adj.get(node)) {
                inDegree[neighbour]--;
                if (inDegree[neighbour] == 0)
                    q.offer(neighbour);
            }
        }

        if (result.size() != V) {
            System.out.println("Cycle detected");
            return new ArrayList<>();
        }

        return result;
    }
}
