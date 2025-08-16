package Heap.MaxSumCombinations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Approach1 {
    public static List<Integer> maxSumCombinations(int a[], int b[], int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b.length; j++) {
                int currSum = a[i] + b[j];

                if (minHeap.size() < k) {
                    minHeap.add(currSum);
                } else if (currSum > minHeap.peek()) {
                    minHeap.poll();
                    minHeap.add(currSum);
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        while (!minHeap.isEmpty()) {
            result.add(minHeap.poll());
        }

        Collections.reverse(result);
        return result;
    }
}
