package com.lia.Tree;

/**
 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.
 * An example is the root-to-leaf path 1->2->3 which represents the number 123.
 * Find the total sum of all root-to-leaf numbers.
 *
 * For example,
 * [1,2,3]
 * The root-to-leaf path 1->2 represents the number 12.
 * The root-to-leaf path 1->3 represents the number 13.
 * Return the sum = 12 + 13 = 25.
 *
 * Created by liqu on 5/18/16.
 */
public class SumRoottoLeafNums_129 {

    public int sumNumbers(TreeNode root) {
        if (root == null) return 0;

        int result = 0;
        return sum(root, 0, result);
    }

    private int sum(TreeNode node, int num, int result) {
        num = 10*num + node.val;
        if (node.left == null && node.right == null) {
            result += num;
        }
        if (node.left != null) result = sum(node.left, num, result);
        if (node.right != null) result = sum(node.right, num, result);
        return result;
    }
}
