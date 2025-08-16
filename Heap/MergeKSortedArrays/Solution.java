package Heap.MergeKSortedArrays;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    static List<Integer> mergeKSortedArrays(List<List<Integer>> list, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Node> minHeap = new PriorityQueue<>();

        for (int i = 0; i < k; i++) {
            minHeap.offer(new Node(i, 0, list.get(i).get(0)));
        }

        while (!minHeap.isEmpty()) {
            Node node = minHeap.poll();
            int i = node.i;
            int j = node.j;
            int val = node.val;

            result.add(val);
            if (j + 1 < list.get(i).size()) {
                minHeap.offer(new Node(i, j + 1, list.get(i).get(j + 1)));
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of arrays:");
        int n = sc.nextInt();
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> arr = new ArrayList<>();
            System.out.println("Enter the number of elements in array " + (i + 1) + " : ");
            int len = sc.nextInt();
            System.out.println("Enter the elements in array " + (i + 1) + " (space-seperated): ");
            for (int j = 0; j < len; j++) {
                arr.add(sc.nextInt());
            }
            list.add(arr);
        }
        sc.close();

        List<Integer> result = mergeKSortedArrays(list, n);
        System.out.println("The sorted List: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
