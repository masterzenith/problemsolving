package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: [1, 3]
 * Output: [], [1], [3], [1,3]
 */
class Subsets {

    public static List<List<Integer>> findSubsets(int[] nums) {
        List<List<Integer>> subsets = new ArrayList<>();
        // start by adding the empty subset
        subsets.add(new ArrayList<>());
        for (int currentNumber : nums) {
            // we will take all existing subsets and insert the current number in them to create new subsets
            int n = subsets.size();
            for (int i = 0; i < n; i++) {
                // create a new subset from the existing subset and insert the current element to it
                List<Integer> set = new ArrayList<>(subsets.get(i));
                set.add(currentNumber);
                subsets.add(set);
            }
        }
        return subsets;
    }

    public static void main(String[] args) {
        List<List<Integer>> result = Subsets.findSubsets(new int[]{1, 3});
        System.out.println("Here is the list of subsets: " + result);

        result = Subsets.findSubsets(new int[]{1, 5, 3});
        System.out.println("Here is the list of subsets: " + result);
    }
}
/**
 * Time: Since, in each step, the number of subsets doubles as we add each element to all the existing
 * subsets, therefore, we will have a total of O(2^N) subsets, where 'N' is the total number of elements
 * in the input set. And since we construct a new subset from an existing set, therefore, the time complexity
 * of the above algo will be O(N*2^N).
 * Space: All the additional space used by our algo is for the output list. Since we will have a total of
 * O(2^N) subsets, and each subset can take up to O(N) space, therefore, the space complexity of our algo will
 * be O(N*2^N)
 */