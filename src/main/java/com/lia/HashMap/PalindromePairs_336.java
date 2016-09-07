package com.lia.HashMap;

import java.util.*;

/**
 * Given a list of unique words. Find all pairs of distinct indices (i, j) in the given list, so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]
 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

 * Created by liqu on 6/14/16.
 */
public class PalindromePairs_336 {
    Set<List<Integer>> set = new HashSet<>();

    public List<List<Integer>> palindromePairs(String[] words) {
        // Build a HashMap to store the <String, Index> pair
        HashMap<String, Integer> wordMap = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            wordMap.put(words[i], i);
        }
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                matchPair(s1, s2, i, wordMap, false);
                matchPair(s2, s1, i, wordMap, true);
            }
        }
        return new ArrayList<>(set);
    }

    /*
    Case1: If s1 is a blank string, then for any string that is palindrome s2, s1+s2 and s2+s1 are palindrome.
    Case 2: If s2 is the reversing string of s1, then s1+s2 and s2+s1 are palindrome.
    Case 3: If s1[0:cut] is palindrome and there exists s2 is the reversing string of s1[cut+1:] ,
    then s2+s1 is palindrome.
    Case 4: Similiar to case3. If s1[cut+1: ] is palindrome and there exists s2 is the reversing string of s1[0:cut],
    then s1+s2 is palindrome.
     */
    private void matchPair(String s1, String s2, int index, HashMap<String, Integer> wordMap, boolean reverse) {
        if (isPalindrome(s1)) {
            String r2 = new StringBuilder(s2).reverse().toString();
            if (wordMap.containsKey(r2) && wordMap.get(r2) != index)
                if (reverse) set.add(Arrays.asList(index, wordMap.get(r2)));
                else set.add(Arrays.asList(wordMap.get(r2), index));
        }
    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int length = s.length();
        int lo = 0, hi = length - 1;
        while (lo < hi) {
            if (lo <= hi) {
                if (Character.toLowerCase(chars[lo]) != Character.toLowerCase(chars[hi])) return false;
                else {
                    lo++; hi--;
                }
            }
        }
        return true;
    }
}
