package com.lia.Tree;

/**
 * Given two binary trees, write a function to check if they are equal or not.
 * Two binary trees are considered equal if they are structurally identical and the nodes have the same value.
 *
 * Created by liqu on 5/9/16.
 */
public class SameTree_100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;

        boolean isLeftSame, isRightSame;
        if (p.val != q.val) return false;
        else {
            isLeftSame = isSameTree(p.left, q.left);
            isRightSame = isSameTree(p.right, q.right);
        }

        return isLeftSame & isRightSame;
    }
}
