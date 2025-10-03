package Graph.NumberOfIslands;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows:");
        int n = sc.nextInt();

        System.out.println("Enter the number of columns");
        int m = sc.nextInt();

        char[][] grid = new char[n][m]; 

        System.out.println("Enter the grid");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        sc.close();

        int num = BFS.numIslands(grid);
        System.out.println("Number of Islands: " + num);
    }
}
