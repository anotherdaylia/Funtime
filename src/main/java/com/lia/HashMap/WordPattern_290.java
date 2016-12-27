package com.lia.HashMap;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a pattern and a string str, find if str follows the same pattern.
 *
 * Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in str.
 *
 * Examples:
 * pattern = "abba", str = "dog cat cat dog" should return true.
 * pattern = "abba", str = "dog cat cat fish" should return false.
 * pattern = "aaaa", str = "dog cat cat dog" should return false.
 * pattern = "abba", str = "dog dog dog dog" should return false.
 * Notes:
 * You may assume pattern contains only lowercase letters,
 * and str contains lowercase letters separated by a single space.
 *
 * Created by liqu on 4/13/16.
 */
public class WordPattern_290 {

    public boolean wordPattern(String pattern, String str) {
        String[] words = str.split(" ");
        int length = pattern.length();
        if (words.length != length) return false;

        Map<String, Integer> map = new HashMap<>();
        for (Integer i = 0; i < length; i++) {
            /* Note:
             * 1. map's put() method returns the previous value associated with key,
             * or null if there was no mapping for key.
             * 2. There are two ways to convert a char to a string
             * - Character.toString(char), this internally uses the next one
             * - String.valueOf(char)
             * - plus operator
             * 3. The reason to + "*" is to avoid patten.charAt(i) and words[i] are the same, which
             * will go to the same bucket
             */
            if (map.put(pattern.charAt(i) + "*", i) != map.put(words[i], i)) {
                return false;
            }
        }
        return true;
    }
}
