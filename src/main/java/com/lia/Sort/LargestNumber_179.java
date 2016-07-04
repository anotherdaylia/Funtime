package com.lia.Sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * For example, given [3, 30, 34, 5, 9], the largest formed number is 9534330.
 * Note: The result may be very large, so you need to return a string instead of an integer.
 *
 * Created by liqu on 6/16/16.
 */
public class LargestNumber_179 {
    public String largestNumber(int[] nums) {
        String[] strarr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strarr[i] = nums[i] + "";
        }

        /*
        Sort array in natural order: Arrays.sort(strarr);
        Shorter string is smaller than longer string if they share the same prefix

        Sort array by the following comparator can make sure return the largest two string combination
        */

        Comparator<String> comp = new Comparator<String>() {
            @Override
            public int compare(String s, String t) {
                String s1 = s + t;
                String s2 = t + s;
                return s1.compareTo(s2);
            }
        };

        Arrays.sort(strarr, comp);

        if(strarr[nums.length-1].charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.insert(0, strarr[i]);
        }

        return sb.toString();
    }

    // Replace the Anonyous new Comparator<String>() with lambda
    public String largestNumberII(int[] nums) {
        String[] strarr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            strarr[i] = nums[i] + "";
        }

//        Comparator<String> comp = new Comparator<String>() {
//            @Override
//            public int compare(String s, String t) {
//                String s1 = s + t;
//                String s2 = t + s;
//                return s1.compareTo(s2);
//            }
//        };

        Comparator<String> comp = (s, t) -> (s + t).compareTo(t + s);
        //Or Comparator<String> comp = (String s, String t) -> { return (s + t).compareTo(t + s);};

        Arrays.sort(strarr, comp);

        if(strarr[nums.length-1].charAt(0) == '0') return "0";

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.insert(0, strarr[i]);
        }

        return sb.toString();
    }
}
