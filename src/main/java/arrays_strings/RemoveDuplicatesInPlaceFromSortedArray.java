package arrays_strings;

import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicatesInPlaceFromSortedArray {

  public static void main(String[] args) {
    int[] arr = {-2, 2, 4, 4, 4, 4, 5, 5};
    System.out.println(bruteForce(arr));
    System.out.println(better(arr));
    System.out.println(optimal(arr));
  }

  //O(nlogn+n) TC  - SC- O(n)
  private static int bruteForce(int[] nums) {
    Set<Integer> set = new LinkedHashSet<>();
    for (int num : nums) {
      set.add(num);
    }

    int k = 0;
    for (int val : set) {
      nums[k++] = val;
    }
    return k;
  }

  //O(n) - TC SC- O(1)
  private static int better(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }

    int k = 1;
    for (int i = 1; i < n; i++) {
      if (nums[i] != nums[k - 1]) {
        nums[k] = nums[i];
        k++;
      }
    }
    return k;
  }

  //O(n) - TC SC- O(1)
  private static int optimal(int[] nums) {
    int n = nums.length;
    if (n == 0) {
      return 0;
    }

    int i = 0;
    for (int j = 1; j < n; j++) {
      if (nums[j] != nums[i]) {
        i++;
        nums[i] = nums[j];
      }
    }
    return i + 1;
  }

}
