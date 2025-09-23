package arrays_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MoveZerosToEndOfArray {

  public static void main(String[] args) {
    int[] arr1 = {1, 0, 2, 3, 0, 4, 0, 1};
    bruteForce(arr1);
    int[] arr2 = {1, 0, 2, 3, 0, 4, 0, 1};
    optimal(arr2);
  }

  //TC - O(n+n)   SC- O(n)
  private static void bruteForce(int[] arr) {

    List<Integer> non_zero = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] != 0) {
        non_zero.add(arr[i]);
      }
    }
    for (int i = 0; i < non_zero.size(); i++) {
      arr[i] = non_zero.get(i);
    }

    for (int i = non_zero.size(); i < arr.length; i++) {
      arr[i] = 0;
    }

    System.out.println(
        Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(",")));

  }

  //O(n) - SC - O(1)
  private static void optimal(int[] arr) {
    int j = -1;
    //find first zero value
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == 0) {
        j = i;
        break;
      }
    }
    if (j >= 0) {
      for (int i = j + 1; i < arr.length; i++) {
        //if there is non zero element swap zero and non-zero element and change zero position
        if (arr[i] != 0) {
          int temp = arr[j];
          arr[j] = arr[i];
          arr[i] = temp;
          j++;
        }
      }
    }
    System.out.println(
        Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(",")));
  }

}
