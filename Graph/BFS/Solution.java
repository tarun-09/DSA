package Graph.BFS;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
    static ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] visited = new int[adj.size()];
        Queue<Integer> q = new LinkedList<>();

        q.offer(0);

        while (!q.isEmpty()) {
            int node = q.poll();

            if (visited[node] == 1)
                continue;

            visited[node] = 1;
            result.add(node);

            for (int neighbour : adj.get(node)) {
                if (visited[neighbour] == 0)
                    q.offer(neighbour);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = scanner.nextInt();
        System.out.print("Enter the adjacency List:\n");
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
            while (true) {
                int node = scanner.nextInt();
                if (node == -1)
                    break;
                adj.get(i).add(node);
            }
        }
        scanner.close();

        ArrayList<Integer> result = bfs(adj);
        System.out.println("BFS Traversal: ");
        for (int element : result) {
            System.out.print(element + " ");
        }
    }
}
