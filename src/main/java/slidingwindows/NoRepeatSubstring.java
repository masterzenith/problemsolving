package slidingwindows;

import java.util.HashMap;
import java.util.Map;

/**Input: String="aabccbb"
 Output: 3
 Explanation: The longest substring without any repeating characters is "abc". */
public class NoRepeatSubstring {
    public static int findLength(String str) {
        int windowStart=0, maxLength=0;
        Map<Character, Integer> charIndexMap = new HashMap<>();
        //try to extend the range [windowStart, windowEnd]
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++){
            char rightChar = str.charAt(windowEnd);
            //if the map already contains 'rightChar',  shrink the window from the beginning so that
            //we have only one occurrence of 'rightChar'
            if (charIndexMap.containsKey(rightChar)){
                //this is tricky; in the current window , we will not have any 'rightChar' after its previous index
                //and if 'windowStart' is already ahead of the last index of 'rightChar', we'll keep 'windowStart'
                windowStart = Math.max(windowStart, charIndexMap.get(rightChar)+1);
            }
            charIndexMap.put(rightChar, windowEnd); //insert the 'rightChar' into the map
            maxLength = Math.max(maxLength, windowEnd-windowStart+1); //remember the maximum length so far
        }
        return maxLength;
    }
    public static void main(){
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("aabccbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abbbb"));
        System.out.println("Length of the longest substring: " + NoRepeatSubstring.findLength("abccde"));
    }
}
/**
 * Time: O(N); N is the number of characters in the input string
 * Space: The algorithm’s space complexity will be O(K),
 * where K is the number of distinct characters in the input string.
 * This also means K<=N, because in the worst case, the whole string might not have any repeating character,
 * so the entire string will be added to the HashMap. Having said that,
 * since we can expect a fixed set of characters in the input string (e.g., 26 for English letters),
 * we can say that the algorithm runs in fixed space O(1); in this case,
 * we can use a fixed-size array instead of the HashMap.*/
