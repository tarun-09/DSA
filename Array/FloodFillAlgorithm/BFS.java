package Array.FloodFillAlgorithm;

import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private static final int[][] directions = {
            { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 }
    };

    public static int[][] floodfill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color)
            return image;

        int oldColor = image[sr][sc];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] { sr, sc });
        image[sr][sc] = color;

        while (!queue.isEmpty()) {
            int[] front = queue.poll();
            int x = front[0], y = front[1];

            for (int[] direction : directions) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                if (nx < 0 || nx > image.length || ny < 0 || ny > image[0].length || image[nx][ny] != oldColor) {
                    continue;
                } 
                image[nx][ny] = color;
                queue.offer(new int[] { nx, ny });
            }
        }

        return image;
    }
}
