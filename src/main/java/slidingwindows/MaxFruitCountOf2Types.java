package slidingwindows;

import java.util.HashMap;
import java.util.Map;

/**
 * Input: Fruit=['A', 'B', 'C', 'B', 'B', 'C']
 * Output: 5
 * Explanation: We can put 3 'B' in one basket and two 'C' in the other basket.
 * This can be done if we start with the second letter: ['B', 'C', 'B', 'B', 'C'] */
public class MaxFruitCountOf2Types {
    public static int findLength(char[] arr) {
        int windowStart = 0, maxLength = 0;
        Map<Character, Integer> fruitFrequencyMap = new HashMap<>();
        //try to extend the range[windowStart,windowEnd]
        for (int windowEnd = 0; windowEnd< arr.length; windowEnd++){
            fruitFrequencyMap.put(arr[windowEnd], fruitFrequencyMap.getOrDefault(arr[windowEnd], 0)+1);
            //shrink the sliding window until we are left with '2' fruits in the frequency map
            while(fruitFrequencyMap.size() > 2){
                fruitFrequencyMap.put(arr[windowStart], fruitFrequencyMap.get(arr[windowStart])-1);
                if (fruitFrequencyMap.get(arr[windowStart])==0){
                    fruitFrequencyMap.remove(arr[windowStart]);
                }
                windowStart++;  // shrink the window
            }
            maxLength = Math.max(maxLength,windowEnd-windowStart+1);
        }
        return maxLength;
    }
    public static void main(String[] args){
        System.out.println("Maximum number of fruits: " + MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'A', 'C'}));
        System.out.println("Maximum number of fruits: " + MaxFruitCountOf2Types.findLength(new char[]{'A', 'B', 'C', 'B', 'B', 'C'}));
    }
}

/**
 * Time: O(N) 'N' number of characters in the input array; outer for loop will run for all the elements where the inner
 * while loop will run each element only once.
 * Space: The algo runs in constant space of O(1) as there can be a maximum of three types of fruits stored in the
 * frequency map*/

/**
 * Problem 1: Longest Substring with at most 2 distinct characters
 *
 * Given a string, find the length of the longest substring in it with at most two distinct characters.
 *
 * Solution: This problem is exactly similar to our parent problem. */