package com.lia.HashMap;

import java.util.HashMap;
import java.util.Map;

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

    public boolean isIsomorphicII(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> map_s = new HashMap<>();
        Map<Character, Integer> map_t = new HashMap<>();
        for (Integer i = 0; i < s.length(); i++) {
            if (map_s.put(s.charAt(i), i) != map_t.put(t.charAt(i), i)) return false;
        }
        return true;
    }
}
