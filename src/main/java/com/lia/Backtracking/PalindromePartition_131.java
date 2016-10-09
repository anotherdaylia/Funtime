package com.lia.Backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.

 Return all possible palindrome partitioning of s.

 For example, given s = "aab",
 Return

 [
 ["aa","b"],
 ["a","a","b"]
 ]

 * Created by liqu on 6/21/16.
 */
public class PalindromePartition_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        partition(result, new ArrayList<>(), s, 0, s.length());
        return result;
    }

    private void partition(List<List<String>> result, List<String> list, String s, int begin, int end) {
        //System.out.println("begin: " + begin + ", end: " + end);
        if (begin >= end) {
            if (!list.isEmpty()) result.add(new ArrayList<>(list));
            return;
        }

        for (int n = end; n > begin; n--) {
            String head = s.substring(begin, n);
            boolean isPali = isPalindrome(head);
            if (!isPali) continue;
            else list.add(head);
            partition(result, list, s, n, s.length());
            if (isPali) list.remove(list.size()-1);
        }
    }

    private boolean isPalindrome(String s) {
        char[] chars = s.toCharArray();
        int lo = 0, hi = s.length() - 1;
        while (lo < hi) {
            if (lo <= hi) {
                if (chars[lo] != chars[hi]) return false;
                else {
                    lo++;hi--;
                }
            }
        }
        return true;
    }
}
