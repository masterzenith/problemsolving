package knapsackdp;

/**
 * Input: {1, 1, 2, 3}, S=4
 * Output: 3
 * The given set has '3' subsets whose sum is '4': {1, 1, 2}, {1, 3}, {1, 3}
 * Note that we have two similar sets {1, 3}, because we have two '1' in our input.
 */
public class SubsetSumBruteForceProblemSolving {
    public int countSubsets(int[] num, int sum) {
        return this.countSubsetsRecursive(num, sum, 0);
    }

    private int countSubsetsRecursive(int[] num, int sum, int currentIndex) {
        // base checks
        if (sum == 0)
            return 1;

        if (num.length == 0 || currentIndex >= num.length)
            return 0;

        // recursive call after selecting the number at the currentIndex
        // if the number at currentIndex exceeds the sum, we shouldn't process this
        int sum1 = 0;
        if (num[currentIndex] <= sum)
            sum1 = countSubsetsRecursive(num, sum - num[currentIndex], currentIndex + 1);

        // recursive call after excluding the number at the currentIndex
        int sum2 = countSubsetsRecursive(num, sum, currentIndex + 1);

        return sum1 + sum2;
    }

    public static void main(String[] args) {
        SubsetSumBruteForceProblemSolving ss = new SubsetSumBruteForceProblemSolving();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
        num = new int[]{1, 2, 7, 1, 5};
        System.out.println(ss.countSubsets(num, 9));
    }
}
/**
 * The time complexity of the above algorithm is exponential O(2^n),
 * where ‘n’ represents the total number. The space complexity is O(n),
 * this memory is used to store the recursion stack.
 */