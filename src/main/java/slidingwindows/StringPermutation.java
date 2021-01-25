package slidingwindows;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: String="oidbcaf", Pattern="abc"
 * Output: true
 * Explanation: The string contains "bca" which is a permutation of the given pattern. */
public class StringPermutation {
    public static boolean findPermutation(String str, String pattern) {
        int windowStart = 0, matched = 0;
        Map<Character, Integer> charFrequencyMap = new HashMap<>();
        for (char chr : pattern.toCharArray())
            charFrequencyMap.put(chr,  charFrequencyMap.getOrDefault(chr,0)+1);
        //our goal is to match all the characters from the 'charFrequencyMap' with the current
        //window try to extend the range [windowStart,  windowEnd]
        for (int windowEnd=0; windowEnd<str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            if (charFrequencyMap.containsKey(rightChar)){
                //decrement the frequency of the matched character
                charFrequencyMap.put(rightChar, charFrequencyMap.get(rightChar)-1);
                if (charFrequencyMap.get(rightChar)==0)//character is completely matched
                    matched++;
            }
            if (matched == charFrequencyMap.size())
                return true;
            if (windowEnd>= pattern.length()-1){//shrink the window by one character
                char leftChar = str.charAt(windowStart++);
                if (charFrequencyMap.containsKey(leftChar)){
                    if (charFrequencyMap.get(leftChar)==0)
                        matched--; //before putting the character back,  decrement the matched out
                    //put the character back  for matching
                    charFrequencyMap.put(leftChar, charFrequencyMap.get(leftChar)+1);
                }
            }
        }
        return false;
    }
    public static void main(String[] args){
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("oidbcaf","abc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("odicf","dc"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("bcdxabcdy","bcdyabcdx"));
        System.out.println("Permutation exist: " + StringPermutation.findPermutation("aaacb","abc"));
    }
}
/**
 * Time:  O(N+M); where 'N' and 'M' are the number of the characters in the input string and the pattern
 * Space: O(M); since in the worst case the whole pattern can have distinct characters that will go into the hashmap*/
