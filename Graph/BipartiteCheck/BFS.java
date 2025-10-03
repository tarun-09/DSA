package Graph.BipartiteCheck;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static boolean checkBipartite(ArrayList<ArrayList<Integer>> adj, int n) {
        int color[] = new int[n];
        Arrays.fill(color, -1);

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                color[i] = 0;
                q.offer(i);

                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int it : adj.get(node)) {
                        if (color[it] == -1) {
                            color[it] = 1 - color[node];
                            q.offer(it);
                        } else if (color[it] == color[node]) {
                            return false;
                        }
                    }
                }
            }
        }

        return true;
    }
}
