package Offer.a59按之字形打印二叉树;

import java.util.*;

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (pRoot == null) {
            return res;
        }
        Queue<TreeNode> levelTraversal = new LinkedList<>();
        levelTraversal.add(pRoot);
        int level = 1;
        while (!levelTraversal.isEmpty()) {
            int size = levelTraversal.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = levelTraversal.remove();
                if (level % 2 == 1) {
                    list.add(tmp.val);
                } else {
                    list.add(0, tmp.val);
                }
                if (tmp.left != null) {
                    levelTraversal.add(tmp.left);
                }
                if (tmp.right != null) {
                    levelTraversal.add(tmp.right);
                }
            }
            level++;
            res.add(list);
        }
        return res;
    }

}