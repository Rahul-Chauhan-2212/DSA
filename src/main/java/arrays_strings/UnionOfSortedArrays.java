package arrays_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class UnionOfSortedArrays {

  public static void main(String[] args) {

    int[] arr1 = {3, 4, 6, 7, 9, 9};
    int[] arr2 = {1, 5, 7, 8, 8};
    bruteForce(arr1, arr2);
    optimal(arr1, arr2);
  }

  // TC - O(n1logn) + O(n2logn) + O(n1+n2)
  // SC - O(n1+n2) + O(n1+n2)
  private static void bruteForce(int[] arr1, int[] arr2) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < arr1.length; i++) {
      set.add(arr1[i]);
    }
    for (int i = 0; i < arr2.length; i++) {
      set.add(arr2[i]);
    }
    int[] union = new int[set.size()];
    int union_index = 0;
    for (Integer num : set) {
      union[union_index++] = num;
    }
    System.out.println(
        Arrays.stream(union).mapToObj(String::valueOf).collect(Collectors.joining(",")));
  }


  //TC - O(n+m) space - O(1)
  private static void optimal(int[] arr1, int[] arr2) {
    List<Integer> union = new ArrayList<>();
    int n = arr1.length;
    int m = arr2.length;

    // This is similar to merge of merge sort
    int i = 0, j = 0;
    while (i < n && j < m) {

      // Skip duplicate elements in the first array
      if (i > 0 && arr1[i - 1] == arr1[i]) {
        i++;
        continue;
      }

      // Skip duplicate elements in the second array
      if (j > 0 && arr2[j - 1] == arr2[j]) {
        j++;
        continue;
      }

      // select and add the smaller element and move
      if (arr1[i] < arr2[j]) {
        union.add(arr1[i]);
        i++;
      } else if (arr1[i] > arr2[j]) {
        union.add(arr2[j]);
        j++;
      }

      // If equal, then add to result and move both
      else {
        union.add(arr1[i]);
        i++;
        j++;
      }
    }

    // Add the remaining elements of arr1[]
    while (i < n) {

      // Skip duplicate elements in the first array
      if (i > 0 && arr1[i - 1] == arr1[i]) {
        i++;
        continue;
      }
      union.add(arr1[i]);
      i++;
    }

    // Add the remaining elements of arr2[]
    while (j < m) {

      // Skip duplicate elements in the second array
      if (j > 0 && arr2[j - 1] == arr2[j]) {
        j++;
        continue;
      }
      union.add(arr2[j]);
      j++;
    }
    System.out.println(union);
  }

}
