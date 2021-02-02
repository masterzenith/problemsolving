package importantSorting;

import java.util.Arrays;

/**
 * We can use an in-place sort like a HeapSort to sort the input array to get the Kth smallest number.
 * Following is the code for this solution:
 */
public class KthSmallestNumberBruteForceHeapSort {
    public static int findKthSmallestNumber(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k - 1];
    }

    public static void main(String[] args) {
        int result = KthSmallestNumberBruteForceHeapSort.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 3);
        System.out.println("Kth smallest number is: " + result);

        // since there are two 5s in the input array, our 3rd and 4th smallest numbers should be a '5'
        result = KthSmallestNumberBruteForceHeapSort.findKthSmallestNumber(new int[]{1, 5, 12, 2, 11, 5}, 4);
        System.out.println("Kth smallest number is: " + result);

        result = KthSmallestNumberBruteForceHeapSort.findKthSmallestNumber(new int[]{5, 12, 11, -1, 12}, 3);
        System.out.println("Kth smallest number is: " + result);
    }
}
/**
 * Sorting will take O(NlogN) and if we are not using an in-place sorting algorithm,
 * we will need O(N) space.
 */