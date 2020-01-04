package LeetCode.A301v500.A337HouseRobberIII;

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

    public int rob(TreeNode root) {
        if (root == null){
            return 0;
        }
        makeRes(root);
        return root.val;
    }

    private TreeNode makeRes(TreeNode root){
        if (root == null){
            return makeRes(new TreeNode(0));
        }
        if (root.left == null && root.right == null){
            root.left =  new TreeNode(0);
            root.right = new TreeNode(0);
            return root;
        }
        root.left = makeRes(root.left);
        root.right = makeRes(root.right);
        root.val = Integer.max(root.val + root.left.left.val + root.left.right.val + root.right.left.val + root.right.right.val,root.left.val + root.right.val);
        return root;
    }

}