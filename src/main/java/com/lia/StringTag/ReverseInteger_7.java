package com.lia.StringTag;

/**
 * Reverse digits of an integer.

 Example1: x = 123, return 321
 Example2: x = -123, return -321

 * Created by liqu on 4/25/16.
 */
public class ReverseInteger_7 {
    public int reverse(int x) {
        if (x >= Integer.MAX_VALUE || x <= Integer.MIN_VALUE) return 0;

        boolean isNegative = false;
        if (x < 0) {
            isNegative = true;
            x = Math.abs(x);
        }

        String numstr = String.valueOf(x);
        StringBuilder sb = new StringBuilder();

        for(int i = numstr.length() - 1; i >= 0; i--) {
            if (numstr.charAt(i) == 0) continue;
            sb.append(numstr.charAt(i));
            //System.out.println(sb.toString());
        }

        numstr = sb.toString();
        if (isNegative){
            numstr =  "-" + numstr;
        }

        if (Long.valueOf(numstr) > Integer.MAX_VALUE || Long.valueOf(numstr) < Integer.MIN_VALUE) return 0;
        else return Integer.valueOf(numstr);

    }
}
