package com.lia.StringTag;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.
 * Created by liqu on 4/30/16.
 */
public class CountAndSay_38 {
    public String countAndSay(int n) {
        String s = "1";

        for (int i = 0; i < n - 1; i++) {
            StringBuilder sb = new StringBuilder();
            int lo = 0, hi = 1;
            while (hi < s.length()) {
                if (s.charAt(lo) != s.charAt(hi)) {
                    sb.append(String.valueOf(hi - lo));
                    sb.append(s.charAt(lo));
                    lo = hi;
                }
                hi++;
            }
            if (s.charAt(lo) == s.charAt(hi - 1)) {
                sb.append(String.valueOf(hi - lo));
                sb.append(s.charAt(lo));
            }
            s = sb.toString();

        }
        return s;
    }
}
