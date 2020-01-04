package LeetCode.A1v300.A251v260.A257BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
    List<String> res = new ArrayList<>();
    public List<String> binaryTreePaths(TreeNode root) {
        if (root == null){
            return res;
        }
        makeRes(root,"");
        return res;
    }

    public void makeRes(TreeNode root, String re) {
        String addStr = root.val + "->";
        re = re + addStr;
        if (root.left == null && root.right == null){
            re = re.substring(0,re.length() - 2);
            res.add(re);
            return;
        }else if (root.left == null){
            makeRes(root.right,re);
        }else if (root.right == null){
            makeRes(root.left,re);
        }else {
            makeRes(root.left,re);
            makeRes(root.right,re);
        }

    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(3);
        new Solution().binaryTreePaths(a);
    }
}