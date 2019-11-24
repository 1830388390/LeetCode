package Offer.a39平衡二叉树;

public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }
    boolean res = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        getHeight(root);
        return res;
    }

    public int getHeight(TreeNode root){
        if (root == null || !res){
            return 0;
        }
        int left = getHeight(root.right) + 1;
        int right = getHeight(root.left) + 1;
        if (Math.abs(left - right) > 1){
            res = false;
            return 0;
        }
        return Math.max(left,right);
    }


}