package com.lia.StringTag;

/**
 * Given two strings S and T, determine if they are both one edit distance apart.
 *
 * Created by liqu on 9/2/16.
 */
public class OneEditDistance_161 {

    public static boolean isOneEditDistance(String s, String t) {
        int m = s.length(), n = t.length();
        if (m > n) return isOneEditDistance(t, s);

        if (n - m > 1) return false;

        int i = 0, shift = n - m;
        while (i < m && s.charAt(i) == t.charAt(i)) i++;
        if (i == m) return shift > 0;

        if (shift == 0) i++;
        while (i < m && s.charAt(i) == t.charAt(i + shift)) i++;
        return i == m;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "abcde";
        boolean res = isOneEditDistance(s, t);
        System.out.print(res);
    }
}
