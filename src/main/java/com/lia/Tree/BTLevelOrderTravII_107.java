package com.lia.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by liqu on 5/17/16.
 */
public class BTLevelOrderTravII_107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        int level = 0;
        travel(root, result, level);
        return result;
    }

    private void travel(TreeNode node, LinkedList<List<Integer>> result, int level) {
        if (node == null) return;
        if (result.size() <= level) {
            result.addFirst(new ArrayList<>());
        }

        List<Integer> list = result.get(result.size() - level - 1);
        list.add(node.val);

        travel(node.left, result, level + 1);
        travel(node.right, result, level + 1);
    }
}
