package com.lia.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Postorder: left, right, root
 *
 * Created by liqu on 5/11/16.
 */
public class BTPostorder_145 {
    public List<Integer> postorderTraversalRec(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postorder(root, list);
        return list;
    }

    private List<Integer> postorder(TreeNode node, ArrayList<Integer> list) {
        if (node == null) return list;

        postorder(node.left, list);
        postorder(node.right, list);
        list.add(node.val);
        return list;
    }


    public List<Integer> postorderTraversalStack(TreeNode root) {
        LinkedList<Integer> list = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return list;

        stack.push(root);
        while (!stack.empty()) {
            TreeNode cur = stack.pop();
            list.addFirst(cur.val);
            if (cur.left != null) stack.push(cur.left);
            if (cur.right != null) stack.push(cur.right);
        }
        return list;
    }


}
