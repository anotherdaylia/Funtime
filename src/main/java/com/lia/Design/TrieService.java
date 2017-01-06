package com.lia.Design;

import java.util.*;

/**
 * Build tries from a list of pairs. Save top 10 for each node.
 *
 * Created by liqu on 10/29/16.
 */
public class TrieService {
    private TrieNode root = null;
    private Comparator<Integer> top10Comparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer i1, Integer i2) {
            return i2 - i1;
        }
    };

    public TrieService() {
        root = new TrieNode();
    }

    public TrieNode getRoot() {
        // Return root of trie root, and
        // lintcode will print the tree struct.
        return root;
    }

    // @param word a string
    // @param frequency an integer
    public void insert(String word, int frequency) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            if (!node.children.containsKey(c)) {
                node.children.put(c, new TrieNode());
            }
            node = node.children.get(c);
            updateFreq(node.top10, frequency);
        }
    }

    private void updateFreq(List<Integer> top10, int freq) {
        int i = 0;
        while (i < top10.size()) {
            if (top10.get(i) > freq) {
                i++;
            } else {
                top10.add(i, freq);
                break;
            }
        }
        if (top10.size() < 10 && i >= top10.size()) {
            top10.add(freq);
        }
    }
}

