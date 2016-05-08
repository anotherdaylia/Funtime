package com.lia.StringTag;

import java.util.HashSet;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 *
 * Examples:
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 *
 * Created by liqu on 5/7/16.
 */
public class LongestSubstirngWoRpChars_3 {

    public int lengthOfLongestSubstringSet(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();

        int lo = 0, hi = 0;
        int maxlength = 0;
        while (lo < chars.length && hi < chars.length) {
            if (!set.contains(chars[hi])){
                set.add(chars[hi]);
                hi++;
                maxlength = Math.max(maxlength, hi - lo);
            }else {
                set.remove(chars[lo]);
                lo++;
            }
        }
        return maxlength;
    }

    // implemented with the template
    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        int[] map = new int[128];

        int lo = 0, hi = 0;
        int counter = 0, maxLength = 0;
        while (hi < chars.length) {
            if (map[chars[hi]] > 0) { counter++; }
            map[chars[hi]]++;
            hi++;

            while (counter > 0){
                if (map[chars[lo]] > 1) { counter--; }
                map[chars[lo]]--;
                lo++;
            }
            maxLength = Math.max(maxLength, hi - lo);
        }
        return maxLength;
    }

}
