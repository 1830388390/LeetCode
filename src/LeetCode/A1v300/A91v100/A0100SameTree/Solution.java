package LeetCode.A1v300.A91v100.A0100SameTree;

public class Solution {
 public class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
}

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null){
            return true;
        }

        if (p != null && q != null && p.val == q.val){
            return isSameTree(p.left,q.left) && isSameTree(p.right,q.right);
        }
        return false;
    }
}
