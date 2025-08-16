package Heap.MaxSumCombinations;

import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the length of the arrays");
        int n = sc.nextInt();

        System.out.println("Enter the values of the array 1 (space-seperated):");
        int[] arr1 = new int[n];
        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        System.out.println("Enter the values of the array 2 (space-seperated):");
        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        System.out.println("Enter the value of K:");
        int k = sc.nextInt();
        sc.close();

        List<Integer> list  = Approach2.maxSumCombinations(arr1, arr2, k);
        System.out.println("K Maximum Sums possible are:");
        for(int val: list) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
