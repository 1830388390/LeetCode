package LeetCode.A1v300.A121v130.A129SumRoottoLeafNumbers;

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
    int sum = 0;
    public int sumNumbers(TreeNode root) {
        if (root == null){
            return 0;
        }
        makeRes(root,0);
        return sum;
    }

    private void makeRes(TreeNode root,int tempSum){
        if (root .left == null && root.right == null){
            sum = sum + tempSum*10 + root.val;
            return;
        }
        tempSum = tempSum*10+ root.val;
        if (root.left != null){
            makeRes(root.left, tempSum);
        }
        if (root.right != null) {
            makeRes(root.right, tempSum);
        }
    }
}