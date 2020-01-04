package LeetCode.A1v300.A111v120.A112PathSum;

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

    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) {
            return false;
        }

        sum -= root.val;
        if ((root.left == null) && (root.right == null)) {
            return (sum == 0);
        }
        return hasPathSum(root.left, sum) || hasPathSum(root.right, sum);
    }
}