package Graph.BipartiteCheck;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DFS {
    public static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n) {
        int color[] = new int[n];
        Arrays.fill(color,-1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, adj)) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean dfs(int node, int c, int color[], ArrayList<ArrayList<Integer>> adj) {
        color[node] = c;
        for (int it : adj.get(node)) {
            if (color[it] == -1) {
                if (!dfs(it, 1 - c, color, adj)) {
                    return false;
                }
            } else if (color[it] == color[node]) {
                return false;
            }
        }   
        return true;
    }
}
