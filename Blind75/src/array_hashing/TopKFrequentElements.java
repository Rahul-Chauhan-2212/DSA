package array_hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

  public static void main(String[] args) {

    int[] arr = {1, 2, 1, 2, 1, 2, 3, 1, 3, 2};
    int k = 2;
    System.out.println(Arrays.stream(bruteForce(arr, k)).boxed().toList());
    System.out.println(Arrays.stream(groupByFreq(arr, k)).boxed().toList());


  }

  //O(nlogn)
  private static int[] bruteForce(int[] arr, int k) {

    Map<Integer, Integer> freqMap = new HashMap<>();
    for (int n : arr) {
      freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
    }
    return freqMap.entrySet()
        .stream()
        .sorted((e1, e2) -> e2.getValue() - e1.getValue())
        .limit(k)
        .map(Map.Entry::getKey)
        .mapToInt(Integer::intValue)
        .toArray();
  }

  //O(n)
  private static int[] groupByFreq(int[] arr, int k) {

    Map<Integer, Integer> freqMap = new HashMap<>();
    List<Integer>[] freq = new List[arr.length + 1];

    for (int i = 0; i < freq.length; i++) {
      freq[i] = new ArrayList<>();
    }
    for (int n : arr) {
      freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
    }
    for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
      freq[entry.getValue()].add(entry.getKey());
    }

    int[] res = new int[k];
    int index = 0;
    for (int i = freq.length - 1; i > 0 && index < k; i--) {
      for (int n : freq[i]) {
        res[index++] = n;
        if (index == k) {
          return res;
        }
      }
    }
    return res;

  }

}
