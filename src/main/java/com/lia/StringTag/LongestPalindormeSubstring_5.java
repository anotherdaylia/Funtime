package com.lia.StringTag;

/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring
 *
 * Created by liqu on 5/6/16.
 */
public class LongestPalindormeSubstring_5 {
    int maxLength = 0, offset = 0;

    public String longestPalindrome(String s) {
        int length = s.length();
        if (length < 2) return s;

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            extendPalindrome(chars, i, i); //for odd palindorme
            extendPalindrome(chars, i, i+1); //for even palindrome
        }
        return  s.substring(offset, offset + maxLength);
    }

    private void extendPalindrome(char[] chars, int lo, int hi) {
        while (lo >= 0 && hi <= chars.length - 1) {
            if (chars[lo] == chars[hi]) {
                lo--;
                hi++;
            } else {
                break;
            }
        }

        if (maxLength < hi - lo - 1) {
            maxLength = hi - lo - 1;
            offset = lo + 1;
        }
    }
}
