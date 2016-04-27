package com.lia.BitManipulation;

/**
 * Given an integer, write a function to determine if it is a power of two.
 *
 * Created by liqu on 4/24/16.
 */
public class PowerOfTwo_231 {

    public boolean isPowerOfTwo(int n) {
        int result = n & (n-1);
        return result == 0;
    }

}
