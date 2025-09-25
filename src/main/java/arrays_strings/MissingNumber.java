package arrays_strings;

public class MissingNumber {

  public static void main(String[] args) {
    int[] arr = {1, 2, 4, 5};
    System.out.println(bruteForce(arr));
    System.out.println(better(arr, 5));
    System.out.println(optimal1(arr, 5));
    System.out.println(optimal2(arr, 5));
  }

  //O(n2)
  private static int bruteForce(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      int flag = 0;
      for (int j = 0; j < arr.length; j++) {
        if (arr[j] == i) {
          flag = 1;
          break;
        }
      }
      if (flag == 0) {
        return i;
      }
    }
    return -1;
  }

  //O(2n) SC - O(n)  //Hashing
  private static int better(int[] arr, int n) {
    int[] hash = new int[n + 1];
    for (int i = 0; i < n - 1; i++) {
      hash[arr[i]] = 1;
    }
    for (int i = 1; i < n - 1; i++) {
      if (hash[i] == 0) {
        return i;
      }
    }
    return -1;
  }


  //Sum O(n)  SC - O(1)
  private static int optimal1(int[] arr, int n) {
    int sum = (n * (n + 1)) / 2;
    int arraySum = 0;
    for (int num : arr) {
      arraySum += num;
    }
    return sum - arraySum;
  }

  //XOR O(n) - SC - O(1)
  private static int optimal2(int[] arr, int n) {
    int xor2 = 0;
    int xor1 = 0;
    for (int i = 0; i < n - 1; i++) {
      xor2 ^= arr[i];
      xor1 ^= (i + 1);
    }
    xor1 ^= n;
    return xor1 ^ xor2;
  }

}
