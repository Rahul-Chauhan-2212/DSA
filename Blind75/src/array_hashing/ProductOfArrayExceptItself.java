package array_hashing;

import java.util.Arrays;

public class ProductOfArrayExceptItself {

  public static void main(String[] args) {

    int[] arr = {-1, 1, 0, -3, 3};
    System.out.println(Arrays.stream(bruteForce(arr)).boxed().toList());
    System.out.println(Arrays.stream(prefix_suffix_array(arr)).boxed().toList());
    System.out.println(Arrays.stream(optimal(arr)).boxed().toList());
  }

  //O(n2)
  public static int[] bruteForce(int[] nums) {
    int[] product = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      int prod = 1;
      for (int j = 0; j < nums.length; j++) {
        if (i != j) {
          prod *= nums[j];
        }
      }
      product[i] = prod;
    }
    return product;
  }

  //O(n)
  public static int[] prefix_suffix_array(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];
    int[] pref = new int[n];
    int[] suff = new int[n];

    pref[0] = 1;
    suff[n - 1] = 1;
    for (int i = 1; i < n; i++) {
      pref[i] = nums[i - 1] * pref[i - 1];
    }
    for (int i = n - 2; i >= 0; i--) {
      suff[i] = nums[i + 1] * suff[i + 1];
    }
    for (int i = 0; i < n; i++) {
      res[i] = pref[i] * suff[i];
    }
    return res;
  }

  //O(n)
  public static int[] optimal(int[] nums) {
    int n = nums.length;
    int[] res = new int[n];

    res[0] = 1;
    for (int i = 1; i < n; i++) {
      res[i] = res[i - 1] * nums[i - 1];
    }

    int postfix = 1;
    for (int i = n - 1; i >= 0; i--) {
      res[i] *= postfix;
      postfix *= nums[i];
    }
    return res;
  }

}
