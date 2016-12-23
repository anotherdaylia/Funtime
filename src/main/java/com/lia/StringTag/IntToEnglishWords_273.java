package com.lia.StringTag;

/**
 * Convert a non-negative integer to its english words representation. Given input is guaranteed to be less than 231 - 1.

 For example,
 123 -> "One Hundred Twenty Three"
 12345 -> "Twelve Thousand Three Hundred Forty Five"
 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

 * Created by liqu on 10/19/16.
 */
public class IntToEnglishWords_273 {
    public class Solution {
        public String numberToWords(int num) {
            String s = String.valueOf(num);

            String[] units = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
            String[] teen = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen" };
            String[] tens = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

            int[] number = new int[10];
            for (int i = 9, j = s.length() - 1; i >= 0 && j >= 0; i--, j--) {
                number[i] = s.charAt(j) - '0';
            }

            StringBuilder res = new StringBuilder();
            if (number[0] != 0) res.append(units[number[0]]).append(" Billion");

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 3; i++){
                sb.setLength(0);
                for (int j = 0; j < 3; j++) {
                    int ix = i * 3 + j + 1;
                    if (number[ix] != 0) {
                        sb.append(" ");
                        if (j == 0) sb.append(units[number[ix]]).append(" Hundred");
                        else if (j == 1) {
                            if (number[ix] == 1) {
                                sb.append(teen[number[ix + 1]]);
                                break;
                            }
                            sb.append(tens[number[ix]]);
                        } else {
                            sb.append(units[number[ix]]);
                        }
                    }
                }
                if (sb.length() > 0) {
                    res.append(sb);
                    if (i == 0) res.append(" Million");
                    else if (i == 1) res.append(" Thousand");
                }

            }

            return res.length() == 0 ? "Zero" : res.toString().trim();
        }

    }
}
