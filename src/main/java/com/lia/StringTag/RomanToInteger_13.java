package com.lia.StringTag;

/**
 * Given a roman numeral, convert it to an integer.
 *
 * Input is guaranteed to be within the range from 1 to 3999.
 *
 * Created by liqu on 4/27/16.
 */
public class RomanToInteger_13 {
    public int romanToInt(String s) {
        int number = 0;
        int[] value = new int[26];

        // initialize value
        value['I' - 'A'] = 1;
        value['V' - 'A'] = 5;
        value['X' - 'A'] = 10;
        value['L' - 'A'] = 50;
        value['C' - 'A'] = 100;
        value['D' - 'A'] = 500;
        value['M' - 'A'] = 1000;

        // adding the 1st letter
        int pre = s.charAt(0) - 'A', cur;
        number += value[pre];
        for (int i = 1; i < s.length(); i++){
            cur = s.charAt(i) - 'A';

            if (value[pre] < value[cur]) {
                number = number - 2 * value[pre] + value[cur];
            } else {
                number += value[cur];
            }
            pre = cur;
        }

        return number;
    }
}
