package A1v300.A101v110.A110BalancedBinaryTree;

public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    boolean res = true;

    public boolean isBalanced(TreeNode root) {
        helper(root);
        return res;

    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left) + 1;
        int right = helper(root.right) + 1;
        if (Math.abs(right - left) > 1) {
            res = false;
        }
        return Math.max(left, right);
    }
}
