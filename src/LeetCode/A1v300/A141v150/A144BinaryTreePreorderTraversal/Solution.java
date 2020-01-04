package LeetCode.A1v300.A141v150.A144BinaryTreePreorderTraversal;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for a binary tree node.

 */
class Solution {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode p = root;
        List<Integer> res = new ArrayList<>();
        while (p != null || !stack.isEmpty()) {
            while (p != null) {
                stack.push(p);
                p = p.left;
            }
            p = stack.pop().right;
            res.add(p.val);
        }
        return res;
    }

}