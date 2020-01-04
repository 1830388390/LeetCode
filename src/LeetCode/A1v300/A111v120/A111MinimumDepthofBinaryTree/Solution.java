package LeetCode.A1v300.A111v120.A111MinimumDepthofBinaryTree;

/**
 * Definition for a binary tree node.
 */
class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int minDepth(TreeNode root) {
        if (root == null){
            return 0;
        }
        if (root.left == null && root.right == null){
            return 1;
        }
        int minDeep = Integer.MAX_VALUE;
        if (root.left != null){
            minDeep= Integer.min(minDepth(root.left) ,minDeep);
        }
        if (root.right != null){
            minDeep= Integer.min(minDepth(root.right) ,minDeep);
        }
        return minDeep + 1;
    }
}