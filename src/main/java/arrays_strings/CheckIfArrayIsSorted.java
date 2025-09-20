package arrays_strings;

public class CheckIfArrayIsSorted {

  public static void main(String[] args) {
    int[] arr = {1, 2, 1, 4, 5};
    System.out.println(isSorted(arr));
    System.out.println(isSorted(new int[]{1, 2, 3, 4, 5}));
  }

  //O(n)
  private static boolean isSorted(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      if (arr[i] > arr[i + 1]) {
        return false;
      }
    }
    return true;
  }

}
