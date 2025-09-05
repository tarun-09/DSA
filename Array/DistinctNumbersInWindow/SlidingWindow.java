package Array.DistinctNumbersInWindow;

import java.util.ArrayList;
import java.util.HashMap;

public class SlidingWindow {
    public static ArrayList<Integer> countDistinct(int[] arr, int n, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        result.add(map.size());

        for (int i = k; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            map.put(arr[i - k], map.get(arr[i - k]) - 1);

            if (map.get(arr[i - k]) == 0) {
                map.remove(arr[i - k]);
            }

            result.add(map.size());
        }

        return result;
    }
}
