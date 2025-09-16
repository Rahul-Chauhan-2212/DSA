package arrays_strings;

import java.util.Stack;


public class ReverseWordsInString {

  //https://leetcode.com/problems/reverse-words-in-a-string/description/
  public static void main(String[] args) {
    System.out.println(usingStringBuilder("a good   example"));
    System.out.println(usingStack("a good   example"));
    System.out.println(usingTwoPointer("a good   example"));
  }

  //O(n)
  private static String usingStringBuilder(String s) {
    String[] words = s.split("\\s+");
    StringBuilder res = new StringBuilder();

    for (int i = words.length - 1; i >= 0; i--) {
      res.append(words[i]);
      if (i != 0) {
        res.append(" ");
      }
    }

    return res.toString().trim();
  }

  //O(n)
  public static String usingStack(String s) {
    String[] words = s.trim().split("\\s+");
    Stack<String> stack = new Stack<>();

    for (String word : words) {
      stack.push(word);
    }

    StringBuilder ans = new StringBuilder();
    while (!stack.isEmpty()) {
      ans.append(stack.pop()).append(" ");
    }
    return ans.toString().trim();
  }

  //O(n) space - O(1) Best for interviews
  private static String usingTwoPointer(String s) {
    int n = s.length();
    StringBuilder ans = new StringBuilder();

    int i = n - 1;
    while (i >= 0) {
      while (i >= 0 && s.charAt(i) == ' ') {
        i--;
      }
      if (i < 0) {
        break;
      }
      int j = i;
      while (j >= 0 && s.charAt(j) != ' ') {
        j--;
      }
      ans.append(s.substring(j + 1, i + 1)).append(" ");
      i = j;
    }
    return ans.toString().trim();
  }

}
