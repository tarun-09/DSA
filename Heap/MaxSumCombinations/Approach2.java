package Heap.MaxSumCombinations;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;

public class Approach2 {
    static void reverse(int arr[]) {
        int l = 0, r = arr.length - 1;
        while (l < r) {
            int temp = arr[l];
            arr[l++] = arr[r];
            arr[r--] = temp;
        }
    }

    public static List<Integer> maxSumCombinations(int a[], int b[], int k) {
        int n = a.length;

        Arrays.sort(a);
        Arrays.sort(b);

        reverse(a);
        reverse(b);

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((x, y) -> y[0] - x[0]);
        HashSet<String> visited = new HashSet<>();

        maxHeap.offer(new int[] { (a[0] + b[0]), 0, 0 });
        visited.add("0#0");

        List<Integer> result = new ArrayList<>();

        while (result.size() < k && !maxHeap.isEmpty()) {
            int[] top = maxHeap.poll();
            int sum = top[0];
            int i = top[1];
            int j = top[2];

            result.add(sum);

            if (i + 1 < n && !visited.contains((i + 1) + "#" + j)) {
                maxHeap.offer(new int[] { (a[i + 1] + b[j]), i + 1, j });
                visited.add((i + 1) + "#" + j);
            }

            if (j + 1 < n && !visited.contains(i + "#" + (j + 1))) {
                maxHeap.offer(new int[] { (a[i] + b[j + 1]), i, j + 1 });
                visited.add(i + "#" + (j + 1));
            }
        }

        return result;
    }
}
