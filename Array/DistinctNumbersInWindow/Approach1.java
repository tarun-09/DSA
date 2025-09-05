package Array.DistinctNumbersInWindow;

import java.util.ArrayList;
import java.util.HashSet;

public class Approach1 {
    public static ArrayList<Integer> countDistinct(int[] arr, int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i <= n - k; i++) {
            HashSet<Integer> set = new HashSet<>();
            for (int j = i; j < i + k; j++) {
                set.add(arr[j]);
            }

            result.add(set.size());
        }

        return result;
    }
}
