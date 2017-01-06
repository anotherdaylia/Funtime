package com.lia.Tree;

import java.util.LinkedList;

/**
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in T
 * that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *
 * Created by liqu on 5/19/16.
 */
public class LowestCommonAncesterBT_236 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        LinkedList<TreeNode> pathP = new LinkedList<>();
        LinkedList<TreeNode> pathQ = new LinkedList<>();
        findNode(root, p, pathP);
        findNode(root, q, pathQ);

        for (TreeNode n : pathQ) {
            if (pathP.contains(n))
                return n;
        }

        return root;
    }

    private boolean findNode(TreeNode node, TreeNode target, LinkedList<TreeNode> list) {
        if (node == null) return false;
        if (node == target) {
            list.add(node);
            return true;
        } else {
            boolean inLeft = findNode(node.left, target, list);
            if (inLeft) {
                list.add(node);
                return true;
            }

            boolean inRight = findNode(node.right, target, list);
            if (inRight) {
                list.add(node);
                return true;
            } else return false;
        }
    }


    /*
    Other's recursive solution
     */
    public TreeNode lowestCommonAncestorRec(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) return null;
        if(root == p || root == q) return root;
        TreeNode left = lowestCommonAncestorRec(root.left, p, q);
        TreeNode right = lowestCommonAncestorRec(root.right, p, q);
        return left != null && right != null ? root :
                                               left == null ? right : left;
    }

    /*
    Lowest common ancestor in N-ary tree

    TreeNode LCA(TreeNode a, TreeNode b, TreeNode root)
	{
		if(a == root || b == root)
			return root;

		int count = 0;
        TreeNode temp = null;

		for(TreeNode iter : root.children)
		{
            TreeNode res = LCA(a, b, iter);
			if(res != null)
			{
				count++;
				temp = res;
			}
		}

        if(count == 0) return null;
		if(count == 2) return root;

		return temp;
	}
     */

}