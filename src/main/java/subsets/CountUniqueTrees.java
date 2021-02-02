package subsets;

/**
 * Input: 3
 * Output: 5
 * Explanation: There will be 5 unique BSTs that can store numbers from 1 to 3.
 */
class CountUniqueTrees {
    public int countTrees(int n) {
        if (n <= 1)
            return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // making 'i' root of the tree
            int countOfLeftSubtrees = countTrees(i - 1);
            int countOfRightSubtrees = countTrees(n - i);
            count += (countOfLeftSubtrees * countOfRightSubtrees);
        }
        return count;
    }

    public static void main(String[] args) {
        CountUniqueTrees ct = new CountUniqueTrees();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }
}
/**
 * Time: The time complexity of this algorithm will be exponential and will be similar to Balanced Parentheses.
 * Estimated time complexity will be O(N*2^N) but the actual time complexity ( O(4^n/sqrt{n})is bounded
 * by the Catalan number and is beyond the scope of a coding interview.
 * https://en.wikipedia.org/wiki/Catalan_number
 * https://en.wikipedia.org/wiki/Central_binomial_coefficient
 * Space: The space complexity of this algorithm will also be exponential, estimated at O(2^N)
 * though the actual will be ( O(4^n/sqrt{n}).
 */
