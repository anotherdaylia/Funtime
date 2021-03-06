package com.lia.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/*
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

 For example:
 Given the binary tree [5,4,8,11,null,13,4,7,2,null,null,5,1] and sum = 22,
 return
 [
   [5,4,11,2],
   [5,8,4,5]
 ]

 * Created by liqu on 5/21/16.
 */
public class PathSumII_113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Stack<Integer> path = new Stack<>();
        findPath(root, sum, path, result);
        return result;
    }

    private void findPath(TreeNode node, int sum, Stack<Integer> path, List<List<Integer>> result) {
        path.push(node.val);

        if (node.left == null && node.right == null) {
            if (node.val == sum) {
                List<Integer> newPath = new ArrayList<>(path);
                result.add(newPath);
            }
        } else {
            if (node.left != null) findPath(node.left, sum - node.val, path, result);
            if (node.right != null) findPath(node.right, sum - node.val, path, result);
        }
        // Making sure to clear the left overs and make sure the stack is ready for the next recursive call.
        path.pop();
    }

    // 1.1.2017, use LinkedList as a stack
    public List<List<Integer>> pathSumII(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> path = new LinkedList<>();
        getPath(root, sum, path, res);
        return res;
    }

    private void getPath(TreeNode node, int sum, LinkedList<Integer> path, List<List<Integer>> res) {
        if (node == null) return;
        path.add(node.val);

        // base case: if node is a leaf
        if (node.left == null && node.right == null) {
            if (node.val == sum) res.add(new ArrayList<>(path));
        } else {
            getPath(node.left, sum - node.val, path, res);
            getPath(node.right, sum - node.val, path, res);
        }
        path.remove(path.size() - 1);
    }
}
