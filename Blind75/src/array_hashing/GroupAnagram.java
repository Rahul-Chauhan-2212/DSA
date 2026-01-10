package array_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {


  public static void main(String[] args) {
    String[] strs = {"act", "pots", "tops", "cat", "stop", "hat"};
    System.out.println(usingSortingAndMap(strs));
    System.out.println(usingFrequencyMap(strs));

  }

  //O(m*nlogn)
  private static List<List<String>> usingSortingAndMap(String[] strs) {
    Map<String, List<String>> res = new HashMap<>();
    for (String s : strs) {
      char[] charArray = s.toCharArray();
      Arrays.sort(charArray);
      String sortedS = new String(charArray);
      res.putIfAbsent(sortedS, new ArrayList<>());
      res.get(sortedS).add(s);
    }
    return new ArrayList<>(res.values());
  }

  //O(m*n)
  private static List<List<String>> usingFrequencyMap(String[] strs) {
    Map<String, List<String>> res = new HashMap<>();
    for (String s : strs) {
      int[] count = new int[26];
      for (char c : s.toCharArray()) {
        count[c - 'a']++;
      }
      String key = Arrays.toString(count);
      res.putIfAbsent(key, new ArrayList<>());
      res.get(key).add(s);
    }
    return new ArrayList<>(res.values());
  }
}
