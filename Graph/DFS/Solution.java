package Graph.DFS;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    static ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] visited = new int[adj.size()];
        dfsUtil(0, adj, visited, result);
        return result;
    }

    static void dfsUtil(int node, ArrayList<ArrayList<Integer>> adj, int[] visited, ArrayList<Integer> result) {
        if (visited[node] == 1) return;  
        visited[node] = 1;
        result.add(node);
        for (int neighbour : adj.get(node)) {
            if (visited[neighbour] == 0) {
                dfsUtil(neighbour, adj, visited, result);
            }
        }
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
                if (node == -1) break;
                adj.get(i).add(node);
            }
        }
        scanner.close();

        ArrayList<Integer> result = dfs(adj);
        System.out.println("DFS Traversal: ");
        for (int element : result) {
            System.out.print(element + " ");
        }
    }
}
