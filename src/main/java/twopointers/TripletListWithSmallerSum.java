package twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Input: [-1, 4, 2, 1, 3], target=5
 * Output: [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 * Explanation: There are four triplets whose sum is less than the target:
 * [-1, 1, 4], [-1, 1, 3], [-1, 1, 2], [-1, 2, 3]
 */
public class TripletListWithSmallerSum {
    public static List<List<Integer>> searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            searchPair(arr, target - arr[i], i, triplets);
        }
        return triplets;
    }

    private static void searchPair(int[] arr, int targetSum, int first, List<List<Integer>> triplets) {
        int left = first + 1, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) { // found the triplet
                // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                // left and right to get a sum less than the target sum
                for (int i = right; i > left; i--)
                    triplets.add(Arrays.asList(arr[first], arr[left], arr[i]));
                left++;
            } else {
                right--; // we need a pair with a smaller sum
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(TripletListWithSmallerSum.searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(TripletListWithSmallerSum.searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}
/**
 * Time: Sorting the array will take O(N*logN).The searchPairs(), in this case, will take O(N^2);  the main while
 * loop will run in O(N) but the nested for loop can also take O(N)-this will happen when the target sum is bigger
 * than every triplet in the array
 * Space: Ignoring the space required for the output array, the space complexity of the above algo will be O(N)
 * which is required for sorting
 */
