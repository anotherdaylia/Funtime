package com.lia.StringTag;

/**
 * Given a string S and a string T, find the minimum window in S which will contain
 * all the characters in T in complexity O(n).

 For example,
 S = "ADOBECODEBANC"
 T = "ABC"
 Minimum window is "BANC".

 Note:
 If there is no such window in S that covers all characters in T, return the empty string "".

 If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

 * Created by liqu on 5/7/16.
 */
public class MinWindowSubstring_76 {
    // Substring problem template:
    // https://leetcode.com/discuss/72701/here-10-line-template-that-can-solve-most-substring-problems

    public String minWindow(String s, String t) {
        int[] map = new int[128];
        char[] charS = s.toCharArray();
        char[] charT = t.toCharArray();
        for (char c : charT) map[c]++;

        int counter = charT.length, minLen = Integer.MAX_VALUE;
        int start = 0, end = 0, head = 0;
        while (end < charS.length) {
            if (map[charS[end]] > 0) { counter--;}
            map[charS[end]]--;
            end++;

            while (counter == 0) {
                if (end - start < minLen) {
                    head = start;
                    minLen = end - start;
                }

                if (map[charS[start]] == 0) {
                    counter++;
                }
                map[charS[start]]++;
                start++;
            }
        }

        return (minLen == Integer.MAX_VALUE) ? "" : s.substring(head, head + minLen);
    }

}
