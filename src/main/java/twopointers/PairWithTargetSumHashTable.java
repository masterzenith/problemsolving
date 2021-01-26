package twopointers;

import java.util.HashMap;

/**
 * Input: [2, 5, 9, 11], target=11
 * Output: [0, 2]
 * Explanation: The numbers at index 0 and 2 add up to 11: 2+9=11
 */
public class PairWithTargetSumHashTable {
    public static int[] search(int[] arr, int targetSum) {
        HashMap<Integer, Integer> nums = new HashMap<>(); //to store the numbers and their indices
        for (int i = 0; i < arr.length; i++) {
            if (nums.containsKey(targetSum - arr[i]))
                return new int[]{nums.get(targetSum - arr[i]), i};
            else
                nums.put(arr[i], i); // put the number and its index in the map
        }
        return new int[]{-1, -1};//pair not found
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSumHashTable.search(new int[]{1, 2, 3, 4, 6}, 6);
        System.out.println("Pair with target sum : [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSumHashTable.search(new int[]{2, 5, 9, 11}, 11);
        System.out.println("Pair with target sum : [" + result[0] + ", " + result[1] + "]");
    }
}
/**
 * Time: O(N); where N is the total number of elements in the given array.
 * Space: O(N); in the worst case, we will be pushing 'N' numbers in the HashTable.
 */
