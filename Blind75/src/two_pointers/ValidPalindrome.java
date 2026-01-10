package two_pointers;

public class ValidPalindrome {

  public static void main(String[] args) {

    String s = "A man, a plan, a canal: Panama";
    System.out.println(bruteForce(s));
    System.out.println(usingTwoPointer(s));
  }

  //O(n)
  private static boolean bruteForce(String s) {
    StringBuilder newStr = new StringBuilder();
    for (char c : s.toCharArray()) {
      if (Character.isLetterOrDigit(c)) {
        newStr.append(Character.toLowerCase(c));
      }
    }
    return newStr.toString().equals(newStr.reverse().toString());
  }

  //O(n)
  private static boolean usingTwoPointer(String s) {
    int l = 0;
    int r = s.length() - 1;
    while (l < r) {
      while (l < r && !Character.isLetterOrDigit(s.charAt(l))) {
        l++;
      }
      while (r > l && !Character.isLetterOrDigit(s.charAt(r))) {
        r--;
      }
      if (Character.toLowerCase(s.charAt(l)) != Character.toLowerCase(s.charAt(r))) {
        return false;
      }
      l++;
      r--;
    }
    return true;
  }

}
