package com.lia.HashMap;

import java.util.HashMap;

/**
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process:
 * Starting with any positive integer, replace the number by the sum of the squares of its digits,
 * and repeat the process until the number equals 1 (where it will stay), or it loops endlessly
 * in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 *
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 *
 * Created by liqu on 4/13/16.
 */

public class HappyNumber_202 {
    public boolean isHappy(int n) {
        HashMap<Integer, Integer> map = new HashMap<>();

        while(!map.containsKey(n)){

            int count = 0;
            int num = n;
            while(num / 10 != 0) {
                count += (num % 10) * (num % 10);
                num = num / 10;
            }
            count += (num % 10) * (num % 10);
            map.put(n, count);
            n = count;
        }

        //if (n == 1) return true;
        //else return false;
        return (n == 1);
    }
}
