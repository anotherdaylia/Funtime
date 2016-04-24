package com.lia.HashMap;

import java.util.HashMap;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

 If the fractional part is repeating, enclose the repeating part in parentheses.

 For example,

 Given numerator = 1, denominator = 2, return "0.5".
 Given numerator = 2, denominator = 1, return "2".
 Given numerator = 2, denominator = 3, return "0.(6)".
 Show Hint

 * Created by liqu on 4/20/16.
 */
public class FractionToRecurringDecimal_166 {

    public String fractionToDecimal(int numerator, int denominator) {
        // HashMap need to use Long to store remainder?
        // -> remainder might be larger than 2^31 - 1
        // for numbers that might exceed 2^31 - 1, then you should use Long
        HashMap<Long, Integer> map = new HashMap<>(); //key: remainder, value: remainder's position

        boolean isNegative = false;
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            isNegative = true;
        }
        long num = Math.abs((long)numerator);
        long den = Math.abs((long)denominator);
        long whole = num / den;
        long remainder = num % den;

        StringBuilder sb = new StringBuilder();
        if(isNegative) sb.append("-");
        sb.append(String.valueOf(whole));

        if(remainder == 0) return sb.toString();
        else sb.append(".");

        boolean isRecurring = false;
        while(remainder != 0) {
            if(!map.containsKey(remainder)){
                map.put(remainder, sb.length());
                whole = remainder * 10 / den;
                remainder = remainder * 10 % den;
                sb.append(whole);
            } else {
                isRecurring = true;
                break;
            }
        }

        if(isRecurring){
            sb.insert(map.get(remainder), "(");
            sb.append(")");
        }
        return sb.toString();
    }
}
