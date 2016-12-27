package com.lia.HashMap;

import java.util.*;

/**
 * Given an array of strings, group anagrams together.
 *
 * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Return:
 *
 * [
 * ["ate", "eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * For the return value, each inner list's elements must follow the lexicographic order.
 * All inputs will be in lower-case.
 *
 * Created by liqu on 4/19/16.
 */

public class GroupAnagrams_49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length < 1) return null;
        List<List<String>> group = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();

        // for lexicographic order
        Arrays.sort(strs);

        for(String word : strs) {
            char[] wchar = word.toCharArray();
            Arrays.sort(wchar);

            String key = String.valueOf(wchar);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }
            map.get(key).add(word);
        }

        for(List<String> list : map.values()){
            group.add(list);
        }

        return group;
    }

    // 12.24.2016
    public List<List<String>> groupAnagramsII(String[] strs) {
        List<List<String>> res = new ArrayList<>();

        Map<String, Integer> map = new HashMap<>();
        for (String s : strs) {
            // sort each string
            char[] chs = s.toCharArray();
            Arrays.sort(chs);
            String sorted = new String(chs);

            if (map.containsKey(sorted)) {
                int ix = map.get(sorted);
                res.get(ix).add(s);
            } else {
                res.add(new ArrayList<>());
                res.get(res.size() - 1).add(s);
                map.put(sorted, res.size() - 1);
            }
        }

        return res;
    }
}
