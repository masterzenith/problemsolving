package twopointers;
/**
 * Input: [1, 2, 3, 4, 6], target=6
 * Output: [1, 3]
 * Explanation: The numbers at index 1 and 3 add up to 6: 2+4=6 */
public class PairWithTargetSum {
    public static int[] search(int[] arr, int targetSum) {
        int left=0, right= arr.length-1;
        while(left<right){
            int currentSum = arr[left]+arr[right];
            if (currentSum==targetSum)
                return new int[]{left,right}; //found the pair
            if (targetSum>currentSum)
                left++; //we need a pair with bigger sum
            else
                right--; //we need a pair with smaller sum
        }
        return new int[] { -1, -1 };
    }
    public static void main(String[] args){
        int[] result =  PairWithTargetSum.search(new int[]{1,2,3,4,6},6);
        System.out.println("Pair with target sum : [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[]{2,5,9,11},11);
        System.out.println("Pair with target sum : [" + result[0] + ", " + result[1] + "]");
    }
}
/**
 * Time: O(N); N is the total numbers of given input array
 * Space: this algo runs in constant space O(1)*/