package subsets;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: 3
 * Output: 5
 * Explanation: There will be 5 unique BSTs that can store numbers from 1 to 3.
 */
public class CountUniqueTreesMemoization {
    Map<Integer, Integer> map = new HashMap<>();

    public int countTrees(int n) {
        if (map.containsKey(n))
            return map.get(n);

        if (n <= 1)
            return 1;
        int count = 0;
        for (int i = 1; i <= n; i++) {
            // making 'i' root of the tree
            int countOfLeftSubtrees = countTrees(i - 1);
            int countOfRightSubtrees = countTrees(n - i);
            count += (countOfLeftSubtrees * countOfRightSubtrees);
        }
        map.put(n, count);
        return count;
    }

    public static void main(String[] args) {
        CountUniqueTreesMemoization ct = new CountUniqueTreesMemoization();
        int count = ct.countTrees(3);
        System.out.print("Total trees: " + count);
    }
}
/**
 * Time: The time complexity of the memoized algorithm will be O(n^2)
 * since we are iterating from ‘1’ to ‘n’ and ensuring that each sub-problem is evaluated only once.
 * Space: The space complexity will be O(n)for the memoization map.
 */
