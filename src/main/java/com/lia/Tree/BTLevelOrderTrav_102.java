package com.lia.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liqu on 5/17/16.
 */
public class BTLevelOrderTrav_102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        int level = 0;
        travel(root, result, level);
        return result;
    }

    private void travel(TreeNode node, List<List<Integer>> result, int level) {
        if (node == null) return;
        if (result.size() <= level) {
            result.add(new ArrayList<>());
        }

        List<Integer> list = result.get(level);
        list.add(node.val);

        travel(node.left, result, level + 1);
        travel(node.right, result, level + 1);
    }
}
