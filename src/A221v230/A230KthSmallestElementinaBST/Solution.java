//package A221v230.A230KthSmallestElementinaBST;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Stack;
//
///**
// * Definition for a binary tree node.
// */
//class TreeNode {
//    int val;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int x) {
//        val = x;
//    }
//}
//
//class Solution {
//
//    List<Integer> res = new ArrayList<>();
//    int k = 0;
//
//    public int kthSmallest(TreeNode root, int k) {
//        this.k = k;
//        makeRes(root);
//        return res.get(res.size() - 1);
//    }
//
//    private void makeRes(TreeNode root) {
//        if (root == null) {
//            return;
//        }
//        makeRes(root.left);
//        if (res.size() == k) {
//            return;
//        }
//        res.add(root.val);
//        makeRes(root.right);
//    }
//}
//
//class Solution2 {
//    public class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int x) {
//            val = x;
//        }
//    }
//
//    public int kthSmallest(TreeNode root, int k) {
//        Stack<TreeNode> stack = new Stack<>();
//        while (root != null || !stack.isEmpty()) {
//            while (root != null) {
//                stack.add(root);
//                root = root.left;
//            }
//            TreeNode tmp = stack.pop();
//            k--;
//            if (k == 0) {
//                return tmp.val;
//            } else {
//                root = tmp.right == null ? root : tmp.right;
//            }
//        }
//        return 0;
//    }
//
//}