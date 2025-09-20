package arrays_strings;

public class CheckIfArrayIsSortedAndRotated {

  public static void main(String[] args) {
    System.out.println(check(new int[]{3, 4, 5, 1, 2}));
  }

  private static boolean check(int[] nums) {
    int count = 0;
    int n = nums.length;
    for (int i = 0; i < n; i++) {
      if (nums[i] > nums[(i + 1) % n] && ++count > 1) {
        return false;
      }
    }
    return true;
  }

}
