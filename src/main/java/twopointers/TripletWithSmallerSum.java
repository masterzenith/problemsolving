package twopointers;

import java.util.Arrays;

/**
 * Input: [-1, 0, 2, 3], target=3
 * Output: 2
 * Explanation: There are two triplets whose sum is less than the target: [-1, 0, 3], [-1, 0, 2]
 */
public class TripletWithSmallerSum {
    public static int searchTriplets(int[] arr, int target) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            count += searchPair(arr, target - arr[i], i);
        }
        return count;
    }

    private static int searchPair(int[] arr, int targetSum, int first) {
        int count = 0;
        int left = first + 1, right = arr.length - 1;
        while (left < right) {
            if (arr[left] + arr[right] < targetSum) {
                //found the triplet
                // since arr[right] >= arr[left], therefore, we can replace arr[right] by any number between
                //left and right to get a sum less than the target sum
                count += right - left;
                left++; //we need a pair with a bigger sum
            } else {
                right--; // we need a pair with a smaller sum
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[]{-1, 0, 2, 3}, 3));
        System.out.println(TripletWithSmallerSum.searchTriplets(new int[]{-1, 4, 2, 1, 3}, 5));
    }
}

/**
 * Time: Sorting the array will take O(N*logN). The searchPair() will take O(N). so overall, searchTriplets()
 * will take O(N*logN+N^2), which is asymptotically equivalent to O(N^2)
 * Space: The space complexity of the above algo will be O(N) which is required for sorting if we are not using an
 * in-place sorting algo
 */
