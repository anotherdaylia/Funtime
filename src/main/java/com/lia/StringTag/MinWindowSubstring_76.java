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
        char[] charS = s.toCharArray();
        int len = Integer.MAX_VALUE; // the length of min window

        // initialize chars in t to tMap
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;

        int head = 0; // the start of min window
        int lo = 0, hi = 0; // pointers to the head/tail of min window
        int counter = t.length();
        while (hi < s.length()) {
            if (map[charS[hi]] > 0) counter--;
            map[charS[hi]]--;
            hi++;

            while (counter == 0) {
                if (len > hi - lo) {
                    len = hi - lo;
                    head = lo;
                }

                /* we visited chars in S but not in T when looping with hi
                   those chars in the map are negative numbers */
                if (map[charS[lo]] == 0) counter++;
                map[charS[lo]]++;
                lo++;
            }
        }
        return (len == Integer.MAX_VALUE) ? "" : s.substring(head, head + len);
    }

}
