package array_hashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestConsecutiveSequence {

  public static void main(String[] args) {
    int[] arr = {0, 3, 7, 2, 5, 8, 4, 6, 0, 1};
    System.out.println(bruteForce(arr));
    System.out.println(usingSorting(arr));
    System.out.println(usingSet(arr));
    System.out.println(usingMap(arr));
  }


  //O(n2)
  private static int bruteForce(int[] nums) {
    int res = 0;
    Set<Integer> store = new HashSet<>();
    for (int num : nums) {
      store.add(num);
    }

    for (int num : nums) {
      int streak = 0, curr = num;
      while (store.contains(curr)) {
        streak++;
        curr++;
      }
      res = Math.max(res, streak);
    }
    return res;
  }

  //(O(nlogn)
  private static int usingSorting(int[] nums) {
    if (nums.length == 0) {
      return 0;
    }
    Arrays.sort(nums);
    int res = 0, curr = nums[0], streak = 0, i = 0;

    while (i < nums.length) {
      if (curr != nums[i]) {
        curr = nums[i];
        streak = 0;
      }
      while (i < nums.length && nums[i] == curr) {
        i++;
      }
      streak++;
      curr++;
      res = Math.max(res, streak);
    }
    return res;
  }

  //O(n)
  private static int usingSet(int[] nums) {
    Set<Integer> numSet = new HashSet<>();
    for (int num : nums) {
      numSet.add(num);
    }
    int longest = 0;

    for (int num : numSet) {
      if (!numSet.contains(num - 1)) {
        int length = 1;
        while (numSet.contains(num + length)) {
          length++;
        }
        longest = Math.max(longest, length);
      }
    }
    return longest;
  }

  //O(n)
  private static int usingMap(int[] nums) {
    Map<Integer, Integer> mp = new HashMap<>();
    int res = 0;

    for (int num : nums) {
      if (!mp.containsKey(num)) {
        mp.put(num, mp.getOrDefault(num - 1, 0) + mp.getOrDefault(num + 1, 0) + 1);
        mp.put(num - mp.getOrDefault(num - 1, 0), mp.get(num));
        mp.put(num + mp.getOrDefault(num + 1, 0), mp.get(num));
        res = Math.max(res, mp.get(num));
      }
    }
    return res;
  }
}
