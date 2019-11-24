package Offer.a4重建二叉树;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 */
public class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> inIndex;
    int preInd = 0;
    int[] pre;
    int[] in;

    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        this.pre = pre;
        this.in = in;
        this.inIndex = new HashMap<>();
        for (int i = 0; i < in.length; i++) {
            inIndex.put(in[i], i);
        }
        return makeTree(0,pre.length - 1);
    }

    private TreeNode makeTree(int left, int right) {
        if (left > right || left < 0 || right >= pre.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[preInd++]);
        int ind = inIndex.get(root.val);
        root.left = makeTree(left,ind - 1);
        root.right = makeTree(ind+1,right);
        return root;
    }
}