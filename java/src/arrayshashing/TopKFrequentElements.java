package arrayshashing;

// https://leetcode.com/problems/top-k-frequent-elements/description/

import java.util.*;

public class TopKFrequentElements {
  public static void main(String[] args) {
    int[] nums = new int[] {4, 1, -1, 2, -1, 2, 3}; // [2, -1]
    int k = 2;
    System.out.println(Arrays.toString(topKFrequent(nums, k)));
  }

  // SOL 1.
  private static int[] topKFrequent(int[] nums, int k) {
    int[] result = new int[k];
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.put(n, map.getOrDefault(n, 0) + 1);
    }

    List<Map.Entry<Integer, Integer>> values = new ArrayList<>(map.entrySet());
    values.sort(Map.Entry.comparingByValue());
    for(int i = 0; i < k; i++) {
      result[i] = values.get(values.size() - 1 - i).getKey();
    }
    return result;
  }
}
