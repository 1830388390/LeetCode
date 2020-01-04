package Offer.a62二叉搜索树第k个节点;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/*

 */
public class Solution {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    TreeNode KthNode(TreeNode pRoot, int k) {
        if (pRoot == null || k <= 0) {
            return null;
        }
        Stack<TreeNode> sequentialTraversal = new Stack<>();
        int num = 1;
        TreeNode tmp = pRoot;
        while (tmp != null || !sequentialTraversal.isEmpty()) {
            while (tmp != null) {
                sequentialTraversal.add(tmp);
                tmp = tmp.left;
            }
            tmp = sequentialTraversal.pop();
            if (num == k) {
                return tmp;
            }
            tmp = tmp.right;
            num++;
        }
        return null;
    }


}