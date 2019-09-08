package A111v120.A113PathSumII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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

    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        makeRes(root, sum, res, new ArrayList<>());
        return res;
    }

    private void makeRes(TreeNode root, int sum, List<List<Integer>> res, ArrayList<Integer> re) {
        if (root == null) {
            return;
        }
        re.add(root.val);
        if (root.left == null && root.right == null && sum - root.val == 0) {
            res.add(new ArrayList<>(re));
        }
        makeRes(root.left, sum - root.val, res, re);
        makeRes(root.right, sum - root.val, res, re);
        re.remove(re.size() - 1);
    }

}

