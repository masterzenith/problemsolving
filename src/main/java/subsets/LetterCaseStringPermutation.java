package subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Input: "ad52"
 * Output: "ad52", "Ad52", "aD52", "AD52"
 */
class LetterCaseStringPermutation {

    public static List<String> findLetterCaseStringPermutations(String str) {
        List<String> permutations = new ArrayList<>();
        if (str == null)
            return permutations;

        permutations.add(str);
        // process every character of the string one by one
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))) { // only process characters, skip digits
                // we will take all existing permutations and change the letter case appropriately
                int n = permutations.size();
                for (int j = 0; j < n; j++) {
                    char[] chs = permutations.get(j).toCharArray();
                    // if the current character is in upper case change it to lower case or vice versa
                    if (Character.isUpperCase(chs[i]))
                        chs[i] = Character.toLowerCase(chs[i]);
                    else
                        chs[i] = Character.toUpperCase(chs[i]);
                    permutations.add(String.valueOf(chs));
                }
            }
        }
        return permutations;
    }

    public static void main(String[] args) {
        List<String> result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ad52");
        System.out.println(" String permutations are: " + result);

        result = LetterCaseStringPermutation.findLetterCaseStringPermutations("ab7c");
        System.out.println(" String permutations are: " + result);
    }
}
/**
 * Time: since we can have 2^N permutations at the most and while processing each permutation we convert
 * it into a character array, the overall time complexity of the algo will be O(N*2^N)
 * Space: all the additional space used by our algo is for the output list. Since we have a total of O(2^N)
 * permutations, the space complexity of our algo is O(N*2^N)
 */