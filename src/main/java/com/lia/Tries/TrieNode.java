package com.lia.Tries;

/**
 * Created by liqu on 6/13/16.
 */
class TrieNode {
    boolean val;
    TrieNode[] next;
    // Initialize your data structure here.
    TrieNode() {
        this.val = false;
        this.next = new TrieNode[26]; // 26 lowercase letters
    }
}
