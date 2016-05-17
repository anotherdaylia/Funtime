package com.lia.StackAndQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 *
 * For example:
 * Given binary tree {3,9,20,#,#,15,7},
 * return its zigzag level order traversal as:
 * [
 * [3],
 * [20,9],
 * [15,7]
 * ]
 *
 * Created by liqu on 5/15/16.
 */
public class BTZigzagLevelOrderTraversal_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        Stack<TreeNode> fromLeft = new Stack<>();
        Stack<TreeNode> fromRight = new Stack<>();

        fromLeft.push(root);

        while(!fromLeft.empty() || !fromRight.empty()) {
            List<Integer> list = new ArrayList<>();
            if (!fromLeft.empty()) {
                while(!fromLeft.empty()) {
                    TreeNode node = fromLeft.pop();
                    if (node != null) {
                        list.add(node.val);
                        fromRight.push(node.left);
                        fromRight.push(node.right);
                    }
                }
            } else {
                while(!fromRight.empty()) {
                    TreeNode node = fromRight.pop();
                    if (node != null) {
                        list.add(node.val);
                        fromLeft.push(node.right);
                        fromLeft.push(node.left);
                    }
                }
            }
            if (list.size() != 0 ) result.add(list);
        }
        return result;
    }

    // DFS solution without Stack
    public List<List<Integer>> zigzagLevelOrderDFS(TreeNode root)
    {
        List<List<Integer>> sol = new ArrayList<>();
        travel(root, sol, 0);
        return sol;
    }

    private void travel(TreeNode curr, List<List<Integer>> sol, int level)
    {
        if(curr == null) return;

        if(sol.size() <= level)
        {
            List<Integer> newLevel = new LinkedList<>();
            sol.add(newLevel);
        }

        List<Integer> collection  = sol.get(level);
        if(level % 2 == 0) collection.add(curr.val);
        else collection.add(0, curr.val);

        travel(curr.left, sol, level + 1);
        travel(curr.right, sol, level + 1);
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
