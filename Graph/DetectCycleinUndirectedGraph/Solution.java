package Graph.DetectCycleinUndirectedGraph;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();
        System.out.println("Enter the number of edges");
        int e = sc.nextInt();
        int[][] edges = new int[e][2];

        System.out.println("Enter the edges (space-seperated):");
        for (int i=0; i<e; i++) {
            edges[i][0] = sc.nextInt();
            edges[i][1] = sc.nextInt();
        }
        sc.close();

        boolean isCycle = DFS.detectCycle(n, edges);
        System.out.println("The Cycle is present in the Graph: " + isCycle);
    }
}
