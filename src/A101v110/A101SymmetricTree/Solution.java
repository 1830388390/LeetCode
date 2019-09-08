package A101v110.A101SymmetricTree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
      public static class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;

          TreeNode(int x) {
              val = x;
          }
      }
    public boolean isSymmetric(TreeNode root) {
          if (root == null){
              return true;
          }
          if (root.left == null && root.right == null){
              return true;
          }
          return isSymmetrics(root.left,root.right);
    }


    boolean isSymmetrics(TreeNode p,TreeNode q) {
        if (p == null && q == null){
            return true;
        }

        if (p != null && q != null && p.val == q.val){
            return isSymmetrics(p.left,q.right) && isSymmetrics(p.right,q.left);
        }
        return false;
    }
}