package arrays_strings;

import java.util.Arrays;

public class LargestElementInArray {

  public static void main(String[] args) {
    int[] arr = {3, 3, 0, 99, -40};
    System.out.println(bruteForce(arr));
    System.out.println(optimal(arr));

  }

  //Sorting O(n2) or best case On(nlogn) depending on algo
  private static int bruteForce(int[] arr) {
    Arrays.sort(arr);
    return arr[arr.length - 1];
  }

  // O(n)
  private static int optimal(int[] arr) {
    int max = 0;
    for (int i = 0; i < arr.length; i++) {
      if (max < arr[i]) {
        max = arr[i];
      }
    }
    return max;
  }

}
