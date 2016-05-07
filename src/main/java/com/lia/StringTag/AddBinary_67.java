package com.lia.StringTag;

/**
 * Given two binary strings, return their sum (also a binary string).

 For example,
 a = "11"
 b = "1"
 Return "100".

 * Created by liqu on 4/30/16.
 */
public class AddBinary_67 {
    public String addBinary(String a, String b) {
        char[] charsA = a.toCharArray();
        char[] charsB = b.toCharArray();
        int length = (charsA.length > charsB.length) ? charsA.length : charsB.length;

        StringBuilder sb = new StringBuilder();

        int carry = 0;
        for (int i = 0; i < length; i++) {
            // '0' ASCII code is 48
            int numA = (charsA.length - 1 - i < 0 ) ? 0 : charsA[charsA.length - 1 - i] - 48;
            int numB = (charsB.length - 1 - i < 0 ) ? 0 : charsB[charsB.length - 1 - i] - 48;
            sb.insert(0, (numA + numB + carry) % 2);
            carry = (numA + numB + carry) / 2;
        }

        if (carry != 0){
            sb.insert(0 , 1);
        }

        return sb.toString();
    }
}
