package com.lia.StringTag;

/**
 * Write a function that takes a string as input and returns the string reversed.
 *
 * Example:
 * Given s = "hello", return "olleh".
 *
 * Created by liqu on 4/27/16.
 */
public class ReverseString_344 {
    public String reverseString(String s) {
        char[] chars = s.toCharArray();
        char[] revchars = new char[s.length()];

        for(int i = s.length() - 1; i >= 0; i--) {
            revchars[s.length() - i - 1] = s.charAt(i);
        }

        return String.valueOf(revchars);

    }
}
