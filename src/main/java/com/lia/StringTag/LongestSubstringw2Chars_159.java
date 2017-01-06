package com.lia.StringTag;

/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

 For example, Given s = “eceba”,

 T is "ece" which its length is 3.

 * Created by liqu on 12/29/16.
 */
public class LongestSubstringw2Chars_159 {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int len = 0;
        int[] map = new int[128];

        int start = 0, end = 0;
        int numDistinct = 0; // keep track of the # of distinct chars
        while (end < s.length()) {
            char c = s.charAt(end);
            // if c is a new char, numDistinct++
            if (map[c] == 0) numDistinct++;
            map[c]++;
            end++;

            while (numDistinct > 2) {
                map[s.charAt(start)]--;
                if (map[s.charAt(start)] == 0) numDistinct--;
                start++;
            }

            len = Math.max(end - start, len);
        }
        return (s.length() > 0) ? len : 0;
    }
}
