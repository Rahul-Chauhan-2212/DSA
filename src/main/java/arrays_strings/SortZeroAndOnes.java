package arrays_strings;

import java.util.Arrays;

public class SortZeroAndOnes {

  //You are given an array of 0s and 1s in random order.
  // Segregate 0s on left side and 1s on right side of the array

  /**
   * Input :  [0, 1, 0, 1, 0, 0, 1, 1, 1, 0] Output :  [0, 0, 0, 0, 0, 1, 1, 1, 1, 1]
   */

  public static void main(String[] args) {
    int[] arr = {0, 1, 0, 1, 0, 0, 1, 1, 1, 0};
    printOutput(bruteForce(arr));
    printOutput(better(arr));
    printOutput(better_2(arr));
    printOutput(optimal(arr));
  }

  private static void printOutput(int[] arr) {
    System.out.println(Arrays.stream(arr)
        .boxed()
        .toList());
  }

  //O(nlog(n)) -- Using sorting
  private static int[] bruteForce(int[] arr) {
    Arrays.sort(arr);
    return arr;
  }

  //O(n+n) -- Using counting
  private static int[] better(int[] arr) {
    int count_0 = 0;
    int count_1 = 0;
    for (int a : arr) {
      if (a == 0) {
        count_0++;
      } else {
        count_1++;
      }
    }
    for (int i = 0; i < count_0; i++) {
      arr[i] = 0;
    }
    for (int i = count_0; i < count_0 + count_1; i++) {
      arr[i] = 1;
    }
    return arr;
  }

  //O(n+n+n)  --- counting sort
  private static int[] better_2(int[] arr) {
    int maxval = 0;
    int n = arr.length;
    for (int k : arr) {
      if (k > maxval) {
        maxval = k;
      }
    }

    int[] count = new int[maxval + 1];

    for (int j : arr) {
      count[j]++;
    }

    for (int i = 1; i <= maxval; i++) {
      count[i] += count[i - 1];
    }

    int[] ans = new int[n];
    for (int i = n - 1; i >= 0; i--) {
      ans[count[arr[i]] - 1] = arr[i];
      count[arr[i]]--;
    }
    return ans;
  }

  //O(n) --- Two Pointer
  private static int[] optimal(int[] arr) {
    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
      if(arr[left]>arr[right]) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;
      }
      left++;
      right--;
    }
    return arr;
  }

}
