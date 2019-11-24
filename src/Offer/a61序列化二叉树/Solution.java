package Offer.a61序列化二叉树;

import java.util.LinkedList;
import java.util.Queue;

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

    String Serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        Queue<TreeNode> levelTraversal = new LinkedList<>();
        levelTraversal.add(root);
        StringBuffer res = new StringBuffer();
        while (!levelTraversal.isEmpty()) {
            int size = levelTraversal.size();
            for (int i = 0; i < size; i++) {
                TreeNode tmp = levelTraversal.remove();
                res.append(tmp == null ? "#!" : tmp.val + "!");
                if (tmp != null) {
                    res.append(tmp.left);
                    res.append(tmp.right);
                }
            }
        }
        while ("#!".equals(res.substring(res.length() - 3))) {
            res.replace(res.length() - 3, res.length(), "");
        }
        return res.toString();
    }

    TreeNode Deserialize(String str) {
        String[] roots = str.split("!");
        if (roots.length == 0) {
            return null;
        }
        Queue<TreeNode> levelTraversal = new LinkedList<>();
        TreeNode root = new TreeNode(Integer.valueOf(roots[0]));
        levelTraversal.add(root);
        int index = 0;
        while (!levelTraversal.isEmpty()) {
            TreeNode tmp = levelTraversal.poll();
            if (tmp != null) {
                if (index + 1 < roots.length) {
                    if ("#".equals(roots[index + 1])) {
                        tmp.left = null;
                        levelTraversal.add(null);
                    } else {
                        TreeNode n = new TreeNode(Integer.valueOf(roots[index + 1]));
                        tmp.left = n;
                        levelTraversal.add(n);
                    }
                    index++;
                }
                if (index + 1 < roots.length) {
                    if ("#".equals(roots[index + 1])) {
                        tmp.right = null;
                        levelTraversal.add(null);
                    } else {
                        TreeNode n = new TreeNode(Integer.valueOf(roots[index + 1]));
                        tmp.right = n;
                        levelTraversal.add(n);
                    }
                    index++;
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        new Solution().Deserialize("1!2!3!#!4!");
    }
}