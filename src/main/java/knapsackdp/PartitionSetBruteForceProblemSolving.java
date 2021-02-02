package knapsackdp;

/**
 * Input: {1, 2, 3, 9}
 * Output: 3
 * Explanation: We can partition the given set into two subsets where minimum absolute difference
 * between the sum of numbers is '3'. Following are the two subsets: {1, 2, 3} & {9}.
 */
public class PartitionSetBruteForceProblemSolving {
    public int canPartition(int[] num) {
        return this.canPartitionRecursive(num, 0, 0, 0);
    }

    private int canPartitionRecursive(int[] num, int currentIndex, int sum1, int sum2) {
        // base check
        if (currentIndex == num.length)
            return Math.abs(sum1 - sum2);

        // recursive call after including the number at the currentIndex in the first set
        int diff1 = canPartitionRecursive(num, currentIndex + 1, sum1 + num[currentIndex], sum2);

        // recursive call after including the number at the currentIndex in the second set
        int diff2 = canPartitionRecursive(num, currentIndex + 1, sum1, sum2 + num[currentIndex]);

        return Math.min(diff1, diff2);
    }

    public static void main(String[] args) {
        PartitionSetBruteForceProblemSolving ps = new PartitionSetBruteForceProblemSolving();
        int[] num = {1, 2, 3, 9};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ps.canPartition(num));
        num = new int[]{1, 3, 100, 4};
        System.out.println(ps.canPartition(num));
    }
}
/**
 * Because of the two recursive calls, the time complexity of the above algorithm is exponential O(2^n),
 * where ‘n’ represents the total number. The space complexity is O(n) which is used to store
 * the recursion stack.
 */