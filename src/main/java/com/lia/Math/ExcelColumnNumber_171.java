package com.lia.Math;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.

 For example:

 A -> 1
 B -> 2
 C -> 3
 ...
 Z -> 26
 AA -> 27
 AB -> 28

 * Created by liqu on 10/9/16.
 */
public class ExcelColumnNumber_171 {
    public int titleToNumber(String s) {
        int number = 0;
        for (int k = 0; k < s.length(); k++) {
            number = number * 26 + s.charAt(k) - 'A' + 1;
        }
        return number;
    }
}
