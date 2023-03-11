package example1;

import java.util.*;

public class Substring_with_Concat_of_all_words_but_now_words_can_have_different_lengths {

	
	 public static List<Integer> findSubstring(String s, String[] words) {
		 
		 List<Integer> result = new ArrayList<>();
	        if (s == null || words == null || words.length == 0) {
	            return result;
	        }
	        
	        int wordCount = words.length;
	        int[] wordLen = new int[wordCount];
	        int concatLen = 0;
	        
	        // create frequency map of words and calculate total lengths
	        Map<String, Integer> wordFreq = new HashMap<>();
	        for (int i = 0; i < wordCount; i++) {
	            String word = words[i];
	            wordFreq.put(word, wordFreq.getOrDefault(word, 0) + 1);
	            wordLen[i] = word.length();
	            concatLen += wordLen[i];
	        }
	        
	        for (int i = 0; i <= s.length() - concatLen; i++) {
	            String substr = s.substring(i, i + concatLen);
	            
	            // check if the substring contains all the words in the words array
	            int wordsFoundLen = 0;
	            Map<String, Integer> substrFreq = new HashMap<>();
	            for (int j = 0; j < concatLen; j += wordsFoundLen) {
	                String word = substr.substring(j, j + wordLen[j / wordCount]);
	                if (!wordFreq.containsKey(word)) {
	                    break;
	                }
	                substrFreq.put(word, substrFreq.getOrDefault(word, 0) + 1);
	                wordsFoundLen = wordLen[j / wordCount];
	                if (substrFreq.get(word) > wordFreq.getOrDefault(word, 0)) {
	                    break;
	                }
	            }
	            
	            if (wordsFoundLen == concatLen && wordFreq.equals(substrFreq)) {
	                result.add(i);
	            }
	        }
	        
	        return result;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String s = "barfoothefoobarrman";
		
		String words[] = new String[]{"foo", "barr"};
		
		System.out.println(findSubstring(s, words));

	}

}
