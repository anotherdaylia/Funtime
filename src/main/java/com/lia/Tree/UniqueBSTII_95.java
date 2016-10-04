package com.lia.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqu on 7/14/16.
 */
public class UniqueBSTII_95 {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        return gTrees(1, n);
    }

    private List<TreeNode> gTrees(int s, int e) {
        List<TreeNode> list = new ArrayList<>();
        if (s > e) {
            list.add(null);
            return list;
        }

        for (int r = s; r <= e; r++) {
            List<TreeNode> left = gTrees(s, r - 1);
            List<TreeNode> right = gTrees(r + 1, e);

            for (TreeNode lnode : left) {
                for (TreeNode rnode : right) {
                    TreeNode root = new TreeNode(r);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        //map.put(s+","+e, list);
        return list;
    }
}
