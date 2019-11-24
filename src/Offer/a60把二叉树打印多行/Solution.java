package Offer.a60把二叉树打印多行;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
        while (!levelTraversal.isEmpty()) {
            int size = levelTraversal.size();
            ArrayList<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = levelTraversal.remove();
                    list.add(tmp.val);
                if (tmp.left != null) {
                    levelTraversal.add(tmp.left);
                }
                if (tmp.right != null) {
                    levelTraversal.add(tmp.right);
                }
            }
            res.add(list);
        }
        return res;
    }

}