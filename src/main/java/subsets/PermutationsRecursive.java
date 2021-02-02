package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: [1,3,5]
 * Output: [1,3,5], [1,5,3], [3,1,5], [3,5,1], [5,1,3], [5,3,1]
 */
class PermutationsRecursive {

    public static List<List<Integer>> generatePermutations(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        generatePermutationsRecursive(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }

    private static void generatePermutationsRecursive(int[] nums, int index, List<Integer> currentPermutation,
                                                      List<List<Integer>> result) {
        if (index == nums.length) {
            result.add(currentPermutation);
        } else {
            // create a new permutation by adding the current number at every position
            for (int i = 0; i <= currentPermutation.size(); i++) {
                List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);
                newPermutation.add(i, nums[index]);
                generatePermutationsRecursive(nums, index + 1, newPermutation, result);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> result = PermutationsRecursive.generatePermutations(new int[] { 1, 3, 5 });
        System.out.print("Here are all the permutations: " + result);
    }
}
/**
 * Time: We know that there are a total of N! permutations of a set with ‘N’ numbers.
 * In the algorithm above, we are iterating through all of these permutations with the help
 * of the two ‘for’ loops. In each iteration, we go through all the current permutations to
 * insert a new number in them on line 17 (line 23 for C++ solution). To insert a number into
 * a permutation of size ‘N’ will take O(N), which makes the overall time complexity of our
 * algorithm O(N*N!)
 * Space: All the additional space used by our algorithm is for the result list and the queue to store
 * the intermediate permutations. If you see closely, at any time, we don’t have more than N! permutations
 * between the result list and the queue. Therefore the overall space complexity to store N! permutations
 * each containing NN elements will be O(N*N!).
 */