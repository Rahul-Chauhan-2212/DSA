package arrays_strings;

import java.util.Stack;

public class RemoveOutermostParentheses {

  //https://leetcode.com/problems/remove-outermost-parentheses/description/
  public static void main(String[] args) {
    System.out.println(stackBased("(()())(())"));
    System.out.println(counterApproach("(()())(())"));

  }

  // O(n)
  private static String stackBased(String s) {
    Stack<Character> stack = new Stack<>();
    StringBuilder ans = new StringBuilder();

    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);

      if (c == '(') {
        if (!stack.isEmpty()) {
          ans.append(c);
        }
        stack.push(c);
      } else {
        stack.pop();
        if (!stack.isEmpty()) {
          ans.append(c);
        }
      }
    }
    return ans.toString();
  }

  //O(n)
  private static String counterApproach(String str) {
    int counter = 0;
    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ')') {
        counter--;
      }
      if (counter != 0) {
        ans.append(str.charAt(i));
      }

      if (str.charAt(i) == '(') {
        counter++;
      }
    }
    return ans.toString();
  }

}
