package A1v300.A101v110.A106ConstructBinaryTreefromInorderandPostorderTraversal;

import java.util.HashMap;

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
    int pre_idx = 0;
    int[] postorder ;
    int[] inorder;
    HashMap<Integer, Integer> idx_map = new HashMap<Integer, Integer>();

    public TreeNode helper(int in_left, int in_right) {
        if (in_left == in_right || pre_idx<0) {
            return null;
        }

        int root_val = postorder [pre_idx];
        TreeNode root = new TreeNode(root_val);

        int index = idx_map.get(root_val);

        pre_idx--;

        root.right = helper(index + 1, in_right);
        root.left = helper(in_left, index);
        return root;
    }

    public TreeNode buildTree(int[] inorder,int[] postorder) {
        this.postorder  = postorder ;
        this.inorder = inorder;

        int idx = 0;
        for (Integer val : inorder) {
            idx_map.put(val, idx++);
        }
        this.pre_idx = postorder.length - 1;
        return helper(0, inorder.length);
    }
}