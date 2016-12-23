package com.lia.StringTag;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 *
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 *
 * Created by liqu on 12/22/16.
 */
public class ShortestPalindrome_214 {
    // Time complexity: O(n^2)
    public String shortestPalindrome(String s) {
        int len = 0;
        for (int i = s.length() / 2; i >= 0; i--) {
            int len1 = expandFromCenter(s, i, i);
            int len2 = expandFromCenter(s, i, i + 1);
            if (len1 > 0 || len2 > 0) {
                len = Math.max(len1, len2);
                break;
            }
        }

        String prefix = new StringBuilder(s.substring(len)).reverse().toString();
        return prefix + s;
    }

    // get the length of palindrome start from index 0 of s
    private int expandFromCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }

        return (left < 0) ? right : -1;
    }
}
