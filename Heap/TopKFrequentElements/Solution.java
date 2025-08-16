package Heap.TopKFrequentElements;

import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static int[] topKFrequent(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x,y)-> y[1]- x[1]);
        for(int key: map.keySet()) {
            maxHeap.offer(new int[] {key, map.get(key)});
        }

        int[] result = new int[k];
        for(int i=0; i<k; i++) {
            result[i] = maxHeap.poll()[0];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the length of the array:");
        int n = sc.nextInt();
        System.out.println("Enter the values of the array (space-seperated):");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of the K:");
        int k = sc.nextInt();
        sc.close();

        int[] result = topKFrequent(arr, k);
        System.out.println("Top K frequent Elements are:");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
    }
}
