package example1;

import java.util.*;

public class Substring_with_Concatenation_of_All_Words {

	
	public static List<Integer> findSubstring(String s, String[] words) {
		
		List<Integer> result = new ArrayList<>();
        
        int wordLen = words[0].length();  //length of first word in array (all words are the same length)
        int wordsCount = words.length;    //number of items(in this case words) in the array
        int concatLen = wordLen * wordsCount;   //length of the concatenated string
        
        // hash map that stores each unique word (from given array: words) as the key and each word's frequency as the value
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String word : words) {
            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
        }
        
        // this for loop with pointer 'i' will track the index of the beginning of each substring atm
        for (int i = 0; i <= s.length() - concatLen; i++) {
            String substr = s.substring(i, i + concatLen);
            
            //hash map that stores each unique word (from given string: s) as the key and each word's frequency as the value 
            Map<String, Integer> substrFreq = new HashMap<>();
            
            // this for loop with pointer 'j' will be our window. it will slide one word at a time.
            for (int j = 0; j < concatLen; j += wordLen) {
                String word = substr.substring(j, j + wordLen);  //words (that are of the same length) from the input string 
                substrFreq.put(word, substrFreq.getOrDefault(word, 0) + 1);  //storing those words into our hash map for the string 
            }
            
            // comparing our two hash maps (the words array hash map and the string hash map)
            if (wordFreq.equals(substrFreq)) {  //if they are equal then we take the beginning index of that substring
                result.add(i);   //pointer 'i' has that index so we add to result
            }
        }
        
        return result;
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "barfoothefoobarman";
		
		String words[] = new String[]{"foo", "bar"};
		
		System.out.println(findSubstring(s, words));
		
	}
}
