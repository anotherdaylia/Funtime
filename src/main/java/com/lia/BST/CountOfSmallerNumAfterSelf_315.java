package com.lia.BST;

import java.util.Arrays;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

 Example:
 Given nums = [5, 2, 6, 1]

 To the right of 5 there are 2 smaller elements (2 and 1).
 To the right of 2 there is only 1 smaller element (1).
 To the right of 6 there is 1 smaller element (1).
 To the right of 1 there is 0 smaller element.
 Return the array [2, 1, 1, 0].

 * Created by liqu on 8/23/16.
 */
public class CountOfSmallerNumAfterSelf_315 {
    /* Construct a tree structure, which has two children,
    *  sum: number of node smaller than itself
    *  dup: number of times this value occur
    */
    class Node {
        Node left, right;
        int val, sum, dup = 1;
        Node(int val, int sum) {
            this.val = val;
            this.sum = sum;
        }
    }
    public List<Integer> countSmaller(int[] nums) {
        Integer[] answer = new Integer[nums.length];
        Node root = null;
        // construct the tree while inserting node from right to left
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(nums[i], root, 0, answer, i);
        }
        return Arrays.asList(answer);
    }

    private Node insert(int val, Node node, int preSum, Integer[] answer, int index) {
        if (node == null) {
            node = new Node(val, 0);
            answer[index] = preSum;
            // if have duplicate, increment dup property and update answer[index]
        }else if (val == node.val) {
            node.dup++;
            answer[index] = preSum + node.sum;
            // if value < node's val, preSum no change because no one is smaller than itself
        }else if (val < node.val) {
            node.sum++;
            node.left = insert(val, node.left, preSum, answer, index);
            // if value > node's val, update preSum because all node's sum and dup should be counted
        }else {
            node.right = insert(val, node.right, preSum + node.sum + node.dup, answer, index);

        }
        return node;
    }
}
