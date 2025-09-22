package arrays_strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LeftRotateArrayByKPlaces {

  public static void main(String[] args) {

    int[] arr = {1, 2, 3, 4, 5};
    int[] arr2 = {1, 2, 3, 4, 5};
    int[] arr3 = {1, 2, 3, 4, 5};
    bruteForce(arr, 7);
    better(arr2, 7);
    optimal(arr3, 7);
  }

  //O(n*d)
  private static void bruteForce(int[] arr, int d) {
    int n = arr.length;
    d = d % n;
    for (int i = 0; i < d; i++) {
      leftRotate(arr);
    }
    System.out.println(
        Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(",")));
  }

  private static void leftRotate(int[] arr) {
    int temp = arr[0];
    for (int i = 1; i < arr.length; i++) {
      arr[i - 1] = arr[i];
    }
    arr[arr.length - 1] = temp;
  }

  //O(n+d) space - O(d)
  private static void better(int[] arr, int d) {
    int n = arr.length;
    d = d % n;

    int[] temp = new int[d];
    for (int i = 0; i < d; i++) {
      temp[i] = arr[i];
    }

    for (int i = d; i < n; i++) {
      arr[i - d] = arr[i];
    }

    for (int i = 0; i < d; i++) {
      arr[n - d + i] = temp[i];
    }
    System.out.println(
        Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(",")));
  }

  //O(n+n) - SC O(1)
  private static void optimal(int[] arr, int d) {
    int n = arr.length;
    d = d % n;

    //Reverse first d
    reverse(arr, 0, d - 1);
    //Reverse remaining n-d
    reverse(arr, d, n - 1);
    //Reverse full array
    reverse(arr, 0, n - 1);
    System.out.println(
        Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(",")));
  }

  private static void reverse(int[] nums, int start, int end) {
    while (start < end) {
      int temp = nums[start];
      nums[start] = nums[end];
      nums[end] = temp;
      start++;
      end--;
    }
  }

}
