package com.lia.StringTag;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

 For example,
 "A man, a plan, a canal: Panama" is a palindrome.
 "race a car" is not a palindrome.

 * Created by liqu on 5/7/16.
 */
public class ValidPalindorme_125 {
    public boolean isPalindrome(String s) {
        int length = s.length();

        int lo = 0, hi = length - 1;
        while (lo < hi) {
            while (lo < hi && !Character.isLetterOrDigit(s.charAt(lo))) {
                lo++;
            }
            while (hi > lo && !Character.isLetterOrDigit(s.charAt(hi))) {
                hi--;
            }
            if (Character.toLowerCase(s.charAt(lo)) != Character.toLowerCase(s.charAt(hi))) return false;
            else {
                lo++;
                hi--;
            }
        }

        return true;
    }
}
