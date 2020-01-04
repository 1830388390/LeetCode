package LeetCode.A1v300.A101v110.A103BinaryTreeZigzagLevelOrderTraversal;

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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
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
        if (level == res.size()){
            res.add(new ArrayList<>());
        }

        if (level%2 == 1){
            res.get(level).add(0,root.val);
        }else {
            res.get(level).add(root.val);
        }
        makeRes(root.left,level + 1);
        makeRes(root.right,level + 1);
    }
}