package arrayshashing;

// https://leetcode.com/problems/two-sum/description/

import java.util.Arrays;

public class TwoSum {
  public static void main(String[] args) {
    int[] nums = new int[] {2, 5, 5, 11};
    int target = 10;

    System.out.println(Arrays.toString(twoSum(nums, target)));
  }

  private static int[] twoSum(int[] nums, int target) {
    int index = 0;
    while (index < nums.length) {
      for (int i = index + 1; i < nums.length; i++) {
        if (nums[i] + nums[index] == target) {
          return new int[] {index, i};
        }
      }
      index++;
    }
    return new int[0];
  }
}
