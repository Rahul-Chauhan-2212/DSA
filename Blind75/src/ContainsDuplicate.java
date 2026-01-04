import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ContainsDuplicate {

  public static void main(String[] args) {
    int[] nums = new int[]{1,2,3,1};
    System.out.println(bruteForce(nums));
    System.out.println(sorting(nums));
    System.out.println(usingSet(nums));
    System.out.println(usingMap(nums));
  }

  //O(n^2)
  private static boolean bruteForce(int[] nums) {
    for(int i=0; i<nums.length; i++) {
      for(int j=i+1; j<nums.length; j++) {
        if(nums[i]==nums[j]) {
          return true;
        }
      }
    }
    return false;
  }

  //O(n)
  private static boolean usingSet(int[] nums) {
    Set<Integer> set = new HashSet<>();
    for (int n: nums){
      if(!set.add(n)) {
        return true;
      }
    }
    return false;
  }

  //O(n)
  private static boolean usingMap(int[] nums) {
    Map<Integer, Integer> map = new HashMap();
    for (int n: nums){
      if (map.containsKey(n) && map.get(n)>1) {
        return true;
      }
      map.put(n, map.getOrDefault(n, 0)+1);
    }
    return false;
  }

  //O(nlog(n))
  private static boolean sorting(int[] nums) {
    Arrays.sort(nums);
    for (int i=1; i<nums.length; i++){
      if(nums[i]==nums[i-1]){
        return true;
      }
    }
    return false;
  }
}
