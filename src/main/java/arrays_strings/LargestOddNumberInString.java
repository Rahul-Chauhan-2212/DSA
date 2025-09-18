package arrays_strings;

public class LargestOddNumberInString {

  /**
   * Input : s = "0214638"
   * <p>
   * Output : "21463"
   */

  public static void main(String[] args) {
    String s = "7542351161";
    System.out.println(bruteForce(s));
    System.out.println(optimal(s));
  }

  //O(n2)
  private static String bruteForce(String num) {
    String ans = "";
    for (int i = 0; i < num.length(); i++) {
      for (int j = i; j < num.length(); j++) {
        String sub = num.substring(i, j + 1);
        if ((int) (sub.charAt(sub.length() - 1)) % 2 != 0) {
          if (ans.isEmpty() || sub.length() > ans.length() ||
              (sub.length() == ans.length() && sub.compareTo(ans) > 0)) {
            ans = sub;
          }
        }
      }
    }
    return ans;
  }


  //O(n)
  private static String optimal(String num) {
    for (int i = num.length() - 1; i >= 0; i--) {
      int digit = num.charAt(i) - '0';
      if (digit % 2 == 1) {
        return num.substring(0, i + 1);
      }
    }
    return "";
  }


}
