package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: [-3, 0, 1, 2, -1, 1, -2]
 * Output: [-3, 1, 2], [-2, 0, 2], [-2, 1, 1], [-1, 0, 1]
 * Explanation: There are four unique triplets whose sum is equal to zero.
 */
public class TripletSumToZero {
    public static List<List<Integer>> searchTriplets(int[] arr) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) //skip same element to avoid duplicate triplets
                continue;
            searchPairs(arr, -arr[i], i + 1, triplets);
        }
        return triplets;
    }

    private static void searchPairs(int[] arr, int targetSum, int left, List<List<Integer>> triplets) {
        int right = arr.length - 1;
        while (left < right) {
            int currentSum = arr[left] + arr[right];
            if (currentSum == targetSum) { //found the triplet
                triplets.add(Arrays.asList(-targetSum, arr[left], arr[right]));
                left++;
                right--;
                while (left < right && arr[left] == arr[left - 1])
                    left++; //skip same element to avoid duplicate triplets
                while (left < right && arr[right] == arr[right + 1])
                    right--;
            } else if (targetSum > currentSum)
                left++; // we need a pair with a bigger sum
            else
                right--;
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2}));
        System.out.println(TripletSumToZero.searchTriplets(new int[]{-5, 2, -1, -2, 3}));
    }
}
/**
 * Time: sorting the array will take O(N*logN). The searchPairs() function will take O(N). As we are calling
 * searchPairs() for every number in the input array, this means that overall searchTriplets() will take O(N*logN+N^2),
 * which is asymptotically equivalent to O(N^2)
 * Space: ignoring the space required for the output array, the space complexity of the above algo will be O(N)
 * which is required for sorting
 */
