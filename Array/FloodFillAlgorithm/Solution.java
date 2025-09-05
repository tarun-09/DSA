package Array.FloodFillAlgorithm;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows and columns of the image");
        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] image = new int[m][n];
        System.out.println("Enter the image pixel by pixel");
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                image[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter the coordiantes of the starting pixel");
        int srow = sc.nextInt();
        int scol = sc.nextInt();

        System.out.println("Enter the value of the new color");
        int color = sc.nextInt();

        sc.close();

        int[][] newImage = DFS.floodfill(image, srow, scol, color);

        System.out.println("The new Image wil be:");
        for(int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                System.out.print(newImage[i][j] + " ");
            }
            System.out.println();
        }
    }
}
