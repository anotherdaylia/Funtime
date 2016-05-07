package com.lia.StringTag;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * Created by liqu on 4/30/16.
 */
public class LongestCommonPrefix_14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length < 1) return "";
        int pos = -1;
        POS_LOOP: for (int p = 0; p < strs[0].length(); p++) {
            char cmp = strs[0].charAt(p);
            for (int i = 0; i < strs.length; i++) {
                if (strs[i].length() < p + 1) {
                    pos = p - 1;
                    break POS_LOOP;
                }
                if (strs[i].charAt(p) != cmp) {
                    pos = p - 1;
                    break POS_LOOP;
                }
            }
            pos = p;
        }

        return strs[0].substring(0, pos + 1);
    }
}
