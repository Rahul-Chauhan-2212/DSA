package arrays_strings;

public class Palindrome {

  public static void main(String[] args) {
    System.out.println(bruteForce("civic"));
    System.out.println(optimal("civic"));
  }

  //O(n)
  private static boolean bruteForce(String str) {
    StringBuilder stringBuilder = new StringBuilder();
    for (int i = str.length() - 1; i >= 0; i--) {
      stringBuilder.append(str.charAt(i));
    }
    return str.equals(stringBuilder.toString());
  }

  //O(n) Two Pointer
  private static boolean optimal(String str) {
    int left = 0;
    int right = str.length() - 1;
    while (left < right) {
      if (str.charAt(left++) != str.charAt(right--)) {
        return false;
      }
    }
    return true;
  }

}
