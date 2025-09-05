package Array.DistinctNumbersInWindow;

import java.util.ArrayList;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of elements in the array:");
        int n = sc.nextInt();
        System.out.println("Enter the size of the window:");
        int k = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        sc.close();

        ArrayList<Integer> result = SlidingWindow.countDistinct(arr, n, k);

        System.out.println("The count of elements in each window is");
        for(int el: result) {
            System.out.print(el + " ");
        }
        System.out.println();
    }   
}
