package Heap.KthLargestInStream;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in); 
        
        System.out.println("Enter the commands for the Kth Largest Stream:");
        String input = sc.nextLine();
        String[] commands = input.split(" ");

        System.out.println("Enter the array for the input:");
        int arr[] = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int x = sc.nextInt();
            if (x != -1) {
                arr[i] = x;
            }
        }

        System.out.println("Enter the length of  array for the initializing the stream:");
        int n = sc.nextInt();
        System.out.println("Enter the array for the initializing the stream:");
        int a[] = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        KthLargest kthLargest = new KthLargest(arr[0], a);
        for (int i = 1; i < commands.length; i++) {
            if (commands[i].equals("add")) {
                System.out.print(kthLargest.add(arr[i]) + " ");
            }
        }
    }
}
