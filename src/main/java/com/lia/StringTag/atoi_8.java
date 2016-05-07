package com.lia.StringTag;

/**
 * Implement atoi to convert a string to an integer.

 Hint: Carefully consider all possible input cases.
 If you want a challenge, please do not see below and ask yourself what are the possible input cases.

 Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 You are responsible to gather all the input requirements up front.

 * Created by liqu on 5/5/16.
 */
public class atoi_8 {
    public int myAtoi(String str) {
        str = str.trim();
        char[] chars = str.toCharArray();
        if (chars.length < 1) return 0;
        int sign = (chars[0] == '-') ? -1 : 1;
        //System.out.println(Integer.MAX_VALUE);
        //System.out.println(Integer.MIN_VALUE);

        long num = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == 0 && (chars[i] == '-' || chars[i] == '+')) {
                continue;
            }
            if (chars[i] >= 48 && chars[i] <= 57) {
                num = num * 10 + chars[i] - 48;
                if (num > Integer.MAX_VALUE && sign > 0) {
                    return Integer.MAX_VALUE;
                } else if (num > 2147483648L && sign < 0) {
                    return Integer.MIN_VALUE;
                }
            } else break;
        }

        return (int) num * sign;
    }
}
