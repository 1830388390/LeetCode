package Offer.a22从上往下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 */

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<>();
        Queue<TreeNode> levelTraversal = new LinkedList<>();
        if (root == null){
            return res;
        }else {
            levelTraversal.add(root);
        }
        while (!levelTraversal.isEmpty()){
            TreeNode tmp = levelTraversal.remove();
            res.add(tmp.val);
            if (tmp.left!=null){
                levelTraversal.add(tmp.left);
            }
            if (tmp.right != null){
                levelTraversal.add(tmp.right);
            }
        }
        return res;

    }
}