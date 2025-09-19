package arrays_strings;

import java.util.Arrays;

public class SecondLargestElementInArray {

  public static void main(String[] args) {
    int[] arr = {7, 7, 2, 2, 10, 10, 10};
    System.out.println(bruteForce(arr));
    System.out.println(better(arr));
    System.out.println(optimal(arr));
  }

  //O(n2) or O(nlogn) depending on algo + O(n)
  private static int bruteForce(int[] arr) {
    Arrays.sort(arr);
    int n = arr.length;
    int largest = arr[n - 1];
    int secondLargest = 0;
    for (int i = n - 2; i >= 0; i--) {
      if (arr[i] != largest) {
        secondLargest = arr[i];
        break;
      }
    }
    return secondLargest;
  }

  //O(n)+O(n)
  private static int better(int[] arr) {
    int largest = 0;
    for (int i = 0; i < arr.length; i++) {
      if (largest < arr[i]) {
        largest = arr[i];
      }
    }
    int secondLargest = 0;
    for (int i = 0; i < arr.length; i++) {
      if (secondLargest < arr[i] && arr[i] != largest) {
        secondLargest = arr[i];
      }
    }
    return secondLargest;
  }

  //O(n)
  private static int optimal(int[] arr) {
    int largest = arr[0];
    int secondLargest = Integer.MIN_VALUE;
    for (int i = 1; i < arr.length; i++) {
      if (arr[i] > largest) {
        secondLargest = largest;
        largest = arr[i];
      } else if (arr[i] < largest && arr[i] > secondLargest) {
        secondLargest = arr[i];
      }
    }
    return secondLargest;
  }

}
