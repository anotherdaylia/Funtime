package com.lia.HashMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.
 Given "bbbbb", the answer is "b", with the length of 1.
 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring,
 "pwke" is a subsequence and not a substring.

 * Created by liqu on 4/19/16.
 */
public class LongestSubstringWORepeatingChar_3 {

    public int lengthOfLongestSubstring(String s) {
        char[] chars = s.toCharArray();
        HashMap<Character, Integer> posMap = new HashMap<>();

        int maxlength = 0, sublength = 0;
        int start = 0;
        for (int i = 0; i < chars.length; i++) {
            // first occurence
            if(!posMap.containsKey(chars[i]) || posMap.get(chars[i]) == -1) {
                posMap.put(chars[i], i); // char[i] index at i
                sublength++;
            } else {

                int end = posMap.get(chars[i]);
                for (int j = start; j <= end; j++) {
                    posMap.put(chars[j], -1);
                }
                start = end + 1;
                posMap.put(chars[i], i);
                sublength = i - start + 1;
            }
            if (sublength > maxlength) maxlength = sublength;
        }

        return maxlength;
    }


    /* if s[j]s[j] have a duplicate in the range [i, j) with index j', we don't need to increase i little by little.
     * We can skip all the elements in the range [i, j'][i,j] and let i to be j' + 1 directly.
     */
    public int lengthOfLongestSubstringEditorial(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>(); // current index of character
        // try to extend the range [i, j]
        for (int j = 0, i = 0; j < n; ++j) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return ans;
    }

    /*
    A sliding window is an abstract concept commonly used in array/string problems.
    A window is a range of elements in the array/string which usually defined by the start and end indices,
    i.e. [i, j)[i,j) (left-closed, right-open).
    A sliding window is a window "slides" its two boundaries to the certain direction.
    For example, if we slide [i, j) to the right by 1 element, then it becomes [i+1, j+1) (left-closed, right-open).

    We use HashSet to store the characters in current window [i, j) (j = ij=i initially).
    Then we slide the index j to the right. If it is not in the HashSet, we slide j further.
    Doing so until s[j] is already in the HashSet. At this point, we found the maximum size of
    substrings without duplicate characters start with index ii. If we do this for all ii, we get our answer.
     */
    public int lengthOfLongestSubstringSlidingWindow(String s) {
        char[] chars = s.toCharArray();
        HashSet<Character> set = new HashSet<>();

        int lo = 0, hi = 0;
        int maxlength = 0, sublength = 0;
        while (lo < chars.length && hi < chars.length) {
            if (!set.contains(chars[hi])){
                set.add(chars[hi]);
                hi++;
                maxlength = Math.max(maxlength, hi - lo);
            }else {
                set.remove(chars[lo]);
                lo++;
            }
        }
        return maxlength;
    }
}
