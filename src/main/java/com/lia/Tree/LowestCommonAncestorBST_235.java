package com.lia.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.
 * According to the definition of LCA on Wikipedia:
 * “The lowest common ancestor is defined between two nodes v and w as the lowest node in
 * T that has both v and w as descendants (where we allow a node to be a descendant of itself).”
 *
 * Created by liqu on 5/11/16.
 */
public class LowestCommonAncestorBST_235 {
    // Trace the BST path solution
    public TreeNode lowestCommonAncestorPath(TreeNode root, TreeNode p, TreeNode q) {
        ArrayList<TreeNode> plist = new ArrayList<>();
        ArrayList<TreeNode> qlist = new ArrayList<>();
        findNode(root, p, plist);
        findNode(root, q, qlist);

        for (int i = qlist.size() - 1; i >= 0; i--) {
            if (plist.contains(qlist.get(i)))
                return qlist.get(i);
        }

        return root;
    }

    private List<TreeNode> findNode(TreeNode node, TreeNode n, List<TreeNode> list) {
        if (node == null ) return list;
        else list.add(node);

        if (n.val < node.val) {
            findNode(node.left, n, list);
        } else if (n.val > node.val) {
            findNode(node.right, n, list);
        } else list.add(n);

        return list;
    }

    /*
        If the value of both nodes p and q are smaller than root, then the common ancestor is on the left of the node
        Similar, if the value of both nodes are larger than root, then the common ancestor is on the right of the node
        The first node whose value is in between that of p and q, that's the common ancestor.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else return root;
    }
}
