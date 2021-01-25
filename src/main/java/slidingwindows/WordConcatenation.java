package slidingwindows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Input: String="catfoxcat", Words=["cat", "fox"]
 * Output: [0, 3]
 * Explanation: The two substring containing both the words are "catfox" & "foxcat". */
public class WordConcatenation {
    public static List<Integer> findWordConcatenation(String str, String[] words) {
        Map<String, Integer> wordFrequencyMap = new HashMap<>();
        for (String word : words)
            wordFrequencyMap.put(word, wordFrequencyMap.getOrDefault(word,0)+1);
        List<Integer> resultIndices = new ArrayList<Integer>();
        int wordsCount = words.length, wordLength = words[0].length();
        for (int i=0; i <= str.length()-wordsCount*wordLength; i++){
            Map<String, Integer> wordsSeen = new HashMap<>();
            for (int j=0; j <wordsCount; j++){
                int nextWordIndex = i + j* wordLength;
                //get the next word from  the string
                String word = str.substring(nextWordIndex, nextWordIndex+wordLength);
                if (!wordFrequencyMap.containsKey(word)) //break  if we don't need  this word
                    break;
                wordsSeen.put(word,wordsSeen.getOrDefault(word,0)+1); // add the word to the 'wordsSeen' map
                //no need to process further if the word has higher frequency than  required
                if (wordsSeen.get(word)> wordFrequencyMap.getOrDefault(word,0))
                    break;
                if (j+1==wordsCount)  //store the index if we have found all the words
                    resultIndices.add(i);
            }
        }
        return resultIndices;
    }
    public static void main(String[] args){
        List<Integer> result = WordConcatenation.findWordConcatenation("catfoxcat", new String[] { "cat", "fox" });
        System.out.println(result);
        result = WordConcatenation.findWordConcatenation("catcatfoxfox", new String[] { "cat", "fox" });
        System.out.println(result);
    }
}
/**
 * Time:  O(N*M*Len); where N is the number of  characters in  the given string , M is total number of words
 * Len is the length of a word.
 * Space: O(M); at most we will be storing all the words in  two HashMaps.  In  the worst case, we also need O(N)
 * space for the resulting  list.  So, the overall  space complexity will be O(N+M)*/
