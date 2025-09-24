package arrays_strings;

public class LinearSearch {

  public static void main(String[] args) {

    int[] arr = {1, 4, 2, 7, 5};
    System.out.println(bruteForce(arr, 2));
  }

  private static int bruteForce(int[] arr, int val) {
    for (int i = 0; i < arr.length; i++) {
      if (arr[i] == val) {
        return i;
      }
    }
    return -1;
  }

}
