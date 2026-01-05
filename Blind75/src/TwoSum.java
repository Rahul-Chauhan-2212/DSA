import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static void main(String[] args) {
    int[] nums = {2, 7, 11, 15};
    int target = 9;
    print(bruteForce(nums, target));
    print(usingHashMap(nums, target));
  }

  private static void print(int[] ans) {
    System.out.println(Arrays.stream(ans).boxed().toList());
  }

  //O(n2)
  private static int[] bruteForce(int[] nums, int target) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i + 1; j < nums.length; j++) {
        if (nums[i] + nums[j] == target) {
          return new int[]{i, j};
        }
      }
    }
    return new int[]{-1, -1};
  }

  //O(n)
  private static int[] usingHashMap(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      int complement = target - nums[i];
      if (map.containsKey(complement)) {
        return new int[]{map.get(complement), i};
      }
      map.put(nums[i], i);
    }
    return new int[]{-1, -1};
  }

}
