package Heap.FindMedianFromStream;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the commands for the Median Finder:");
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
        sc.close();

        MedianFinder medianFinder = new MedianFinder();
        for (int i = 1; i < commands.length; i++) {
            if (commands[i].equals("addNum")) {
                medianFinder.addNum(arr[i]);
                System.out.print("null ");
            }
            if (commands[i].equals("findMedian"))
                System.out.print(medianFinder.findMedian() + " ");
        }
    }
}
