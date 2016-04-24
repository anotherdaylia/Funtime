package com.lia.HashMap;

import java.util.HashMap;

/**
 * Given two strings s and t, determine if they are isomorphic.
 *
 * Two strings are isomorphic if the characters in s can be replaced to get t.
 *
 * All occurrences of a character must be replaced with another character while preserving the order of characters.
 * No two characters may map to the same character but a character may map to itself.
 *
 * For example,
 * Given "egg", "add", return true.
 * Given "foo", "bar", return false.
 * Given "paper", "title", return true.
 *
 * Created by liqu on 4/13/16.
 */

public class IsomorphicString_205 {
    public boolean isIsomorphicArr(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        if(s.length() != t.length()) return false;
        // data indicates that converting to char array is faster than charAt()
        char[] s_arr = s.toCharArray();
        char[] t_arr = t.toCharArray();

        for(int i = 0; i < s_arr.length; i++) {
            if(map.containsKey(s_arr[i])){
                if(map.get(s_arr[i]) != (t_arr[i])) return false;
            } else {
                // case: s = "ab", t = "aa"
                if(map.containsValue(t_arr[i])) return false;
                map.put(s_arr[i], t_arr[i]);
            }

        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        if(s.length() != t.length()) return false;
        //char[] s_arr = s.toCharArray();
        //char[] t_arr = t.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            if(map.containsKey(s.charAt(i))){
                if(map.get(s.charAt(i)) != t.charAt(i)) return false;
            } else {
                // case: s = "ab", t = "aa"
                if(map.containsValue(t.charAt(i))) return false;
                map.put(s.charAt(i), t.charAt(i));
            }

        }
        return true;
    }
}
