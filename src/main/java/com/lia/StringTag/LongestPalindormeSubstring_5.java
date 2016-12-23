package com.lia.StringTag;

/**
 * Given a string S, find the longest palindromic substring in S.
 * You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring
 *
 * Created by liqu on 5/6/16.
 */
public class LongestPalindormeSubstring_5 {
    /*
     Extend solution: O(n^2) runtime, O(1) space
     We observe that a palindrome mirrors around its center.
     Therefore, a palindrome can be expanded from its center, and there are only 2n - 12n−1 such centers
      */
    public String longestPalindrome(String s) {
        int start = 0, end = 0; // substring starting point (0,0)

        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length - 1; i++) {
            int len1 = extendPalindrome(chars, i, i); //with odd number of char
            int len2 = extendPalindrome(chars, i, i+1); //with even number of char
            int len = Math.max(len1, len2);
            if (len > end - start) { // find longer palindrome, update start/end point
                start =  i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return  s.substring(start, end + 1);
    }

    // return the length of the palindrome
    private int extendPalindrome(char[] chars, int lo, int hi) {
        while (lo >= 0 && hi <= chars.length - 1) {
            if (chars[lo] == chars[hi]) {
                lo--;
                hi++;
            } else break;
        }
        return hi - lo - 1;
    }
}
