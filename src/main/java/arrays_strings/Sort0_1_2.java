package arrays_strings;

import java.util.Arrays;

public class Sort0_1_2 {

  //https://leetcode.com/problems/sort-colors/description/
  public static void main(String[] args) {
    int[] arr = {2, 0, 2, 1, 1, 0};
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
      } else if (a == 1) {
        count_1++;
      }
    }
    for (int i = 0; i < count_0; i++) {
      arr[i] = 0;
    }
    for (int i = count_0; i < count_0 + count_1; i++) {
      arr[i] = 1;
    }
    for (int i = count_0 + count_1; i < arr.length; i++) {
      arr[i] = 2;
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

  // O(n)  -- Dutch National Flag algorithm
  // follows 0... low-1 ---> 0, low... mid-1 ---> 1, high+1... n-1 ---> 2
  private static int[] optimal(int[] arr) {
    int low = 0;
    int mid = 0;
    int high = arr.length - 1;
    while (mid <= high) {
      if (arr[mid] == 0) {
        int temp = arr[low];
        arr[low] = arr[mid];
        arr[mid] = temp;
        low++;
        mid++;
      } else if (arr[mid] == 1) {
        mid++;
      } else {
        int temp = arr[mid];
        arr[mid] = arr[high];
        arr[high] = temp;
        high--;
      }
    }
    return arr;
  }


}
