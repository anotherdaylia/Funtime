package com.lia.StringTag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Given a list of unique words, find all pairs of distinct indices (i, j) in the given list,
 * so that the concatenation of the two words, i.e. words[i] + words[j] is a palindrome.

 Example 1:
 Given words = ["bat", "tab", "cat"]
 Return [[0, 1], [1, 0]]
 The palindromes are ["battab", "tabbat"]

 Example 2:
 Given words = ["abcd", "dcba", "lls", "s", "sssll"]
 Return [[0, 1], [1, 0], [3, 2], [2, 4]]
 The palindromes are ["dcbaabcd", "abcddcba", "slls", "llssssll"]

 * Created by liqu on 12/22/16.
 */
public class PalindromePairs_336 {

    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>(); //<word, index>

        for (int i = 0; i < words.length; i++) map.put(words[i], i);

        /*
        1. The <= in for (int j=0; j<=words[i].length(); j++) is aimed to handle empty string in the input.
           Consider the test case of ["a", ""];
        2. Since we now use <= in for (int j=0; j<=words[i].length(); j++) instead of <.
           There may be duplicates in the output (consider test case ["abcd", "dcba"]).
           Therefore I put a str2.length()!=0 to avoid duplicates.
        3. Another way to avoid duplicates is to use Set<List<Integer>> ret = new HashSet<>();
           and return new ArrayList<>(ret);
         */
        for (int i = 0; i < words.length; i++) {
            for (int j = 0; j <= words[i].length(); j++) {
                String s1 = words[i].substring(0, j);
                String s2 = words[i].substring(j);
                if (isPalindrome(s1)) {
                    String s2_rev = new StringBuilder(s2).reverse().toString();
                    if (map.containsKey(s2_rev) && map.get(s2_rev) != i) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(map.get(s2_rev));
                        pair.add(i);
                        result.add(pair);
                    }
                }
                if (isPalindrome(s2)) {
                    String s1_rev = new StringBuilder(s1).reverse().toString();
                    if (map.containsKey(s1_rev) && map.get(s1_rev) != i && s2.length() != 0) {
                        List<Integer> pair = new ArrayList<>();
                        pair.add(i);
                        pair.add(map.get(s1_rev));
                        result.add(pair);
                    }
                }
            }
        }
        return result;
    }

    private boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i <= j) {
            if (s.charAt(i) == s.charAt(j)) {
                i++;
                j--;
            } else return false;
        }

        return true;
    }
}
