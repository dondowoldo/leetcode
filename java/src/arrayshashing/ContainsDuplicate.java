package arrayshashing;

// https://leetcode.com/problems/contains-duplicate/description/

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class ContainsDuplicate {
  public static void main(String[] args) {
    System.out.println(containsDuplicate(new int[] {2, 14, 18, 22, 22})); // true
    System.out.println(containsDuplicate(new int[] {1, 2, 3, 1})); // true
    System.out.println(containsDuplicate(new int[] {1, 2, 3, 4})); // false
    System.out.println(containsDuplicate(new int[] {1, 1, 1, 3, 3, 4, 3, 2, 4, 2})); // true
  }

  // SOL 1. Using SET
  private static boolean containsDuplicate(int[] nums) {
    Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    return numSet.size() != nums.length;
  }


  // SOL 2. Brute force ( O(n^2))
  private static boolean containsDuplicate2(int[] nums) {
    int len = nums.length;
    for(int i = 0; i < len; i++) {
      for (int j = i + 1; j < len; j++) {
        if (nums[j] == nums[i]) {
          return true;
        }
      }
    }
    return false;
  }
}
