package slidingwindows;
/**
 * Input: [2, 1, 5, 1, 3, 2], k=3
 * Output: 9
 * Explanation: Subarray with maximum sum is [5, 1, 3].
 */
public class MaxSumSubArrayOfSizeKOptimum {
    public static int findMaxSumSubArray(int k, int [] arr){
        int windowSum=0, maxSum=0;
        int windowStart = 0;
        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++){
            windowSum += arr[windowEnd]; //add the next element
            //slide the window,  we don't need to slide if we don't hit the required window size of 'k'
            if (windowEnd >= k-1){
                maxSum =  Math.max(maxSum,windowSum);
                windowSum -= arr[windowStart]; // subtract the element going out
                windowStart++; // slide the window ahead
            }
        }
        return maxSum;
    }
    public static void main(String [] args){
        System.out.println("Maximum size of a subarray of size k :" +MaxSumSubArrayOfSizeKOptimum.findMaxSumSubArray(3, new int[]{2,1,5,1,3,2}));
        System.out.println("Maximum size of a subarray of size k :" +MaxSumSubArrayOfSizeKOptimum.findMaxSumSubArray(2, new int[]{2, 3, 4, 1, 5}));
    }
}
/**
 * Time complexity: O(N)
 * Space complexity: O(1)
 */
