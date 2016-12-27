package com.lia.HashMap;

import java.util.*;

/**
 * Given a non-empty array of integers, return the k most frequent elements.

For example,
Given [1,1,1,2,2,3] and k = 2, return [1,2].

Note:
You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

 * Created by liqu on 12/26/16.
 */
public class TopKFreqElements_347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Node> map = new HashMap<>();
        PriorityQueue<Node> maxPQ = new PriorityQueue<>(
            new Comparator<Node>() {
                public int compare(Node v, Node w){
                    return w.freq - v.freq;
                }
            });

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.get(nums[i]).freq++;
            } else {
                map.put(nums[i], new Node(nums[i]));
            }
        }

        for (Map.Entry<Integer, Node> entry : map.entrySet()) {
            maxPQ.add(entry.getValue());
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            result.add(maxPQ.poll().num);
        }
        return result;
    }

    class Node {
        int num;
        int freq;
        public Node(int num){
            this.num = num;
            this.freq = 1;
        }
    }

}
