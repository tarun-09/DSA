package Graph.NumberOfIslands;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    public static int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int[][] visited = new int[n][m];
        int count = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '1') {
                    count++;
                    bfs(grid, i, j, visited);
                }
            }
        }
        return count;
    }

    private static void bfs(char[][] grid, int row, int col, int[][] visited) {
        int n = grid.length;
        int m = grid[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});

        visited[row][col] = 1;

        int delRow[] = {-1, 0, 1, 0};
        int delCol[] = {0, 1, 0, -1};

        while (!q.isEmpty()) {
            int[] current = q.poll();
            int r = current[0];
            int c = current[1];

            for (int i = 0; i < 4; i++) {
                int nRow = r + delRow[i];
                int nCol = c + delCol[i];

                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && visited[nRow][nCol] == 0 && grid[nRow][nCol] == '1') {
                    visited[nRow][nCol] = 1;
                    q.offer(new int[]{nRow, nCol});
                }
            }
        }
    }

}
