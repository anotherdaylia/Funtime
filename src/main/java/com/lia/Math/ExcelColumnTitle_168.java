package com.lia.Math;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.

 For example:

 1 -> A
 2 -> B
 3 -> C
 ...
 26 -> Z
 27 -> AA
 28 -> AB

 * Created by liqu on 10/9/16.
 */
public class ExcelColumnTitle_168 {
    public String convertToTitle(int n) {
        if (n <= 0) return "";
        StringBuilder ret = new StringBuilder();
        while (n > 0) {
            n--; // because + 'A' will add 1 more, so need to decrement n by 1 first
            ret.append((char) ('A' + (n % 26)));
            n /= 26;
        }
        return ret.reverse().toString();
    }
}
