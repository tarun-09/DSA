package Graph.BipartiteCheck;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes");
        int n = sc.nextInt();

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the number of adjacent nodes for node " + i);
            int m = sc.nextInt();
            System.out.println("Enter the adjacent nodes for node " + i);
            for (int j = 0; j < m; j++)
                adj.get(i).add(sc.nextInt());
        }
        sc.close();

        boolean isBipartite = DFS.checkBipartite(adj, n);
        if (isBipartite) {
            System.out.println("The graph is bipartite");
        } else {
            System.out.println("The graph is not bipartite");
        }

    }
}