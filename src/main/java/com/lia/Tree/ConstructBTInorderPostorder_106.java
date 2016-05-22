package com.lia.Tree;

import java.util.HashMap;

/**
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree
 *
 * Created by liqu on 5/20/16.
 */
public class ConstructBTInorderPostorder_106 {
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length < 1 || postorder.length < 1) return null;
        //Use a HashMap to record the index of root in the inorder array.
        HashMap<Integer, Integer> indexMap = new HashMap<>(); // <Vaue, Index>
        for (int i = 0; i < inorder.length; i++) { indexMap.put(inorder[i], i); }
        return buildTree(inorder, 0, inorder.length-1, postorder, 0, postorder.length-1);
    }

    private TreeNode buildTree(int[] inorder, int in_lo, int in_hi, int[] postorder, int post_lo, int post_hi) {
        if (in_lo > in_hi || post_lo > post_hi) return null;

        int rootVal = postorder[post_hi];
        int rootIx = -1;
        for (int i = in_lo; i <= in_hi; i++) {
            if (inorder[i] == rootVal) rootIx = i;
        }

        int leftLen = rootIx - in_lo, rightLen = in_hi - rootIx;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, in_lo, rootIx - 1, postorder, post_lo, post_lo + leftLen - 1);
        root.right = buildTree(inorder, rootIx + 1, in_hi, postorder, post_lo + leftLen, post_lo + leftLen + rightLen - 1);

        return root;

    }

    private TreeNode buildTree(int[] inorder, int in_lo, int in_hi, int[] postorder, int post_lo, int post_hi, HashMap<Integer, Integer> indexMap) {
        if (in_lo > in_hi || post_lo > post_hi) return null;

        int rootVal = postorder[post_hi];
        int rootIx = indexMap.get(rootVal);

        int leftLen = rootIx - in_lo, rightLen = in_hi - rootIx;
        TreeNode root = new TreeNode(rootVal);
        root.left = buildTree(inorder, in_lo, rootIx - 1, postorder, post_lo, post_lo + leftLen - 1, indexMap);
        root.right = buildTree(inorder, rootIx + 1, in_hi, postorder, post_lo + leftLen, post_lo + leftLen + rightLen - 1, indexMap);

        return root;
    }
}
