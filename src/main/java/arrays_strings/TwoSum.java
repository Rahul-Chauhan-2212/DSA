package arrays_strings;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class TwoSum {

  // Given an array of integers nums and an integer target,
  // return indices of the two numbers such that they add up to target
  /*
  Input: nums = [2,7,11,15], target = 9
  Output: [0,1]
  Explanation: Because nums[0] + nums[1] == 9, we return [0, 1]
   */
  //https://leetcode.com/problems/two-sum/description/
  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    printOutput(bruteForce(nums, target));
    printOutput(better(nums, target));
    System.out.println(optimal(new int[]{3, 2, 4}, 6));
  }

  private static void printOutput(int[] arr) {
    System.out.println(Arrays.stream(arr)
        .boxed()
        .toList());
  }

  //O(n^2)
  private static int[] bruteForce(int[] arr, int k) {
    for (int i = 0; i < arr.length; i++) {
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[i] + arr[j] == k) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{-1, -1};
  }

  //O(n) - Hashing
  private static int[] better(int[] arr, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < arr.length; i++) {
      int complement = k - arr[i];
      if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
      }
      map.put(arr[i], i);
    }
    return new int[]{-1, -1};
  }

  //O(n) + O(nlog(n))  -- 2 Pointer
  private static boolean optimal(int[] arr, int k) {
    Arrays.sort(arr);
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
      int sum = arr[left] + arr[right];
      if (sum == k) {
        return true;
      } else if (sum < k) {
        left++;
      } else {
        right--;
      }
    }
    return false;
  }

}
