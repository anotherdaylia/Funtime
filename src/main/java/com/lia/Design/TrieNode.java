package com.lia.Design;

import java.util.ArrayList;
import java.util.List;
import java.util.NavigableMap;
import java.util.TreeMap;

/**
 * Created by liqu on 10/29/16.
 */
class TrieNode {
    public NavigableMap<Character, TrieNode> children;
    public List<Integer> top10;

    public TrieNode() {
        children = new TreeMap<Character, TrieNode>();
        List<Integer> top10 = new ArrayList<Integer>();
    }
}
