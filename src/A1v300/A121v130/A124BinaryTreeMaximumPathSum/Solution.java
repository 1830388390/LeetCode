package A1v300.A121v130.A124BinaryTreeMaximumPathSum;

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

    int maxSum = -Integer.MAX_VALUE;
    public int maxPathSum(TreeNode root) {
        makeRes(root);
        return maxSum;
    }
    private int makeRes(TreeNode root){
        if (root == null){
            return 0;
        }
        int left = Integer.max(makeRes(root.left),0);
        int right = Integer.max(makeRes(root.right),0);
        int maxPath = Integer.max(left,right);
        maxSum = Integer.max(maxSum,root.val + left + right);
        if(root.val + maxPath >0){
            maxSum = Integer.max(maxSum,root.val + maxPath);
            return root.val + maxPath;
        }else {
            maxSum = Integer.max(maxSum,root.val + maxPath);
            return root.val + maxPath;
        }
    }
}