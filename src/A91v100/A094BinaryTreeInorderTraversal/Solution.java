package A91v100.A094BinaryTreeInorderTraversal;


import java.util.ArrayList;
import java.util.List;

class Solution {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        if (root == null) {
            return res;
        }

        makeRes(root);
        return res;
    }

    private void makeRes(TreeNode root) {
        if (root == null) {
            return;
        }
        makeRes(root.left);
        res.add(root.val);
        makeRes(root.right);
    }
}

