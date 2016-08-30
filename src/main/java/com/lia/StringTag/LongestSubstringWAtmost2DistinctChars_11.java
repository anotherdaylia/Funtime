package com.lia.StringTag;

/**
 * Given a string, find the length of the substring T that contains at most two distinct characters.
 * for example,
 * Given S = "eceba",
 * T is "ece" which its length is 3.
 *
 * Created by liqu on 8/29/16.
 */
public class LongestSubstringWAtmost2DistinctChars_11 {

    /*
     This is a general solution to the case where T contains at most k distinct characters.
     The key is when we adjust the sliding window to satisfy the invariant,
     we need a counter of the number of times each character appears in the substring.
    */
    public int lengthOfSubstringTwoDistinctChar(String s) {
        int[] count = new int[256];
        int max = 0, numDistinct = 0;
        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            char c = s.charAt(j);
            if (count[c] == 0) numDistinct++;
            count[c]++;

            while (numDistinct > 2) {
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0) numDistinct--;
                i++;
            }
            max = Math.max(max, j - i + 1);
        }
        return max;
    }
}
