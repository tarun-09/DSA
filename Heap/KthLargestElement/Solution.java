package Heap.KthLargestElement;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array");
        int n = sc.nextInt();
        System.out.println("Enter the value of K:");
        int k = sc.nextInt();
        System.out.println("Enter the values of the array (space-seperated):");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int result = Approach3.kthLargestElement(arr, k);
        System.out.println("The Kth largest element of the Array is: " + result);
    }
}
