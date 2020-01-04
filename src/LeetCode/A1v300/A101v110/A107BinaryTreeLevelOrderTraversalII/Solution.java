package LeetCode.A1v300.A101v110.A107BinaryTreeLevelOrderTraversalII;

import java.util.ArrayList;
import java.util.List;

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
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null){
            return res;
        }
        makeRes(root,0);
        return res;

    }
    private void makeRes(TreeNode root,int level){
        if (root == null){
            return;
        }

        if (level>=res.size()){
            res.add(0,new ArrayList<>());
        }
        res.get(res.size() - 1 - level).add(root.val);
        makeRes(root.left,level+1);
        makeRes(root.right,level+1);
    }
}