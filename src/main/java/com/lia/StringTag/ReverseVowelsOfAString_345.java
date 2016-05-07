package com.lia.StringTag;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 *
 * Example 1:
 * Given s = "hello", return "holle".
 * Example 2:
 * Given s = "leetcode", return "leotcede".
 *
 * Created by liqu on 4/30/16.
 */
public class ReverseVowelsOfAString_345 {
    public String reverseVowels(String s) {
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');

        char[] chars = s.toCharArray();
        int lo = 0, hi = chars.length - 1;

        while (lo < hi) {
            while (lo < chars.length && !vowels.contains(chars[lo])){
                lo++;
            }
            while (hi > 0 && !vowels.contains(chars[hi])){
                hi--;
            }
            if (lo < hi) {
                //System.out.println("exch: lo: " + chars[lo] + ", hi: " + chars[hi]);
                exch(chars, lo, hi);
                //System.out.println("exch: lo: " + chars[lo] + ", hi: " + chars[hi]);
                lo++;
                hi--;
            }
        }
        return String.valueOf(chars);
    }

    private void exch(char[] chars, int lo, int hi) {
        char tmp = chars[lo];
        chars[lo] = chars[hi];
        chars[hi] = tmp;
    }
}
