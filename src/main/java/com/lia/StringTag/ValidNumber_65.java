package com.lia.StringTag;

/**
 * Validate if a given string is numeric.

 Some examples:
 "0" => true
 " 0.1 " => true
 "abc" => false
 "1 a" => false
 "2e10" => true
 Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

 * Created by liqu on 8/29/16.
 */
public class ValidNumber_65 {

    public boolean isNumber(String s) {
        s = s.trim();
        int n = s.length();
        if (n < 1) return false;

        int i = 0;
        char first = s.charAt(i);
        if (first == '+' || first == '-') i++; // validate the optional sign

        first = s.charAt(i);
        if (i < n && first == 'e') return false; // the first character is 'e'
        if (i < n && first == '.' && i == n - 1) return false; // '.' is the only character
        if (i+1 < n && first == '.' && s.charAt(i+1) == 'e') return false;

        boolean decimal = false, sci = false;
        while (i < n) {
            char c = s.charAt(i);
            if (Character.isDigit(c)){
                i++;
            } else if (c == 'e') {
                if (sci) return false; // have 'e' notation already
                if (i == n-1) return false; // 'e' is the last character
                sci = true;
                i++;
            } else if (c == '.') {
                if (decimal || sci) return false;
                decimal = true;
                i++;
            } else if (c == '+' || c == '-') {
                if (s.charAt(i-1) != 'e') return false;
                if (i == n-1) return false;
                i++;
            } else  return false;
        }
        return true;
    }
}
