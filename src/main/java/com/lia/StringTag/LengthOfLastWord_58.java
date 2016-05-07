package com.lia.StringTag;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.

 If the last word does not exist, return 0.

 Note: A word is defined as a character sequence consists of non-space characters only.

 For example,
 Given s = "Hello World",
 return 5.

 * Created by liqu on 4/30/16.
 */
public class LengthOfLastWord_58 {
    public int lengthOfLastWord(String s) {
        if (s.length() < 1) return 0;
        s = s.trim();
        int p = s.length() - 1;

        while (p >=0){
            if (s.charAt(p) == 32) break;
            else p--;
        }

        return s.length() - 1 - p;
    }
}
