import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Anagram {

  public static void main(String[] args) {
    String s = "racecar", t = "carrace";
    System.out.println(usingSorting(s, t));
    System.out.println(usingHashMap(s, t));
    System.out.println(usingFrequency(s, t));
  }

  //O(nlogn)+ O(mlogm)
  private static boolean usingSorting(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    char[] s_chars = s.toCharArray();
    char[] t_chars = t.toCharArray();
    Arrays.sort(s_chars);
    Arrays.sort(t_chars);
    return Arrays.equals(s_chars, t_chars);
  }


  //O(n)
  private static boolean usingHashMap(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    Map<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
      map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) - 1);
    }
    for (Entry<Character, Integer> entry : map.entrySet()) {
      if (entry.getValue() != 0) {
        return false;
      }
    }
    return true;
  }

  //O(n)
  private static boolean usingFrequency(String s, String t) {
    if (s.length() != t.length()) {
      return false;
    }
    int[] freq = new int[26];
    for (int i = 0; i < s.length(); i++) {
      freq[s.charAt(i) - 'a']++;
      freq[t.charAt(i) - 'a']--;
    }
    for (int a : freq) {
      if (a != 0) {
        return false;
      }
    }
    return true;
  }

}
