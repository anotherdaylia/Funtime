package com.lia.Tree;

import java.util.HashMap;

/**
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 *
 * Note:
 * You may assume that duplicates do not exist in the tree.
 *
 * Created by liqu on 5/21/16.
 */
public class ConstructBTInorderPreorder_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (inorder.length < 1 || preorder.length < 1) return null;
        HashMap<Integer, Integer> indexMap = new HashMap<>(); // <Vaue, Index>
        for (int i = 0; i < inorder.length; i++) { indexMap.put(inorder[i], i); }
        return buildTree(inorder, 0, inorder.length-1, preorder, 0, preorder.length-1, indexMap);
    }

    private TreeNode buildTree (int[] inorder, int in_lo, int in_hi, int[] preorder, int pre_lo, int pre_hi,
                                HashMap<Integer, Integer> indexMap) {

        if (in_lo > in_hi || pre_lo > pre_hi) return null;

        int rootVal = preorder[pre_lo];
        int rootIx = indexMap.get(rootVal);

        int leftLen = rootIx - in_lo, rightLen = in_hi - rootIx;
        TreeNode root = new TreeNode(rootVal);
        root.left =
                buildTree(inorder, in_lo, rootIx - 1, preorder, pre_lo + 1, pre_lo + leftLen, indexMap);
        root.right =
                buildTree(inorder, rootIx + 1, in_hi, preorder, pre_lo + 1 + leftLen, pre_lo + leftLen + rightLen, indexMap);
        return root;
    }
}
