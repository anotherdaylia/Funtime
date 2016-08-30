package com.lia.StringTag;

import java.util.Arrays;
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

    // Sliding window solution that use array as a set
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

    // O(n) run time, O(1) space
    public int lengthOfLongestSubstringII(String s) {
        int[] map = new int[128];
        Arrays.fill(map, -1);
        int max = 0, i = 0;

        for (int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (map[c] >= i) { // found repeated character in range (i,j)
                i = map[c] + 1;
            }
            map[c] = j;
            max = Math.max(max, j - i + 1);
        }
        return max;
    }


}
