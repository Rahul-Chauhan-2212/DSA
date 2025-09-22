package arrays_strings;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LeftRotateArrayByOnePlace {

  public static void main(String[] args) {

    int[] arr = {1, 2, 3, 4, 5};
    bruteForce(arr);
  }

  //O(n)
  private static void bruteForce(int[] arr) {
    int temp = arr[0];
    for (int i = 1; i < arr.length; i++) {
      arr[i - 1] = arr[i];
    }
    arr[arr.length - 1] = temp;
    System.out.println(
        Arrays.stream(arr).mapToObj(String::valueOf).collect(Collectors.joining(",")));
  }

}
