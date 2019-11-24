package A1v300.A231v240.A235LowestCommonAncestorofaBinarySearchTree;

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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        int val = root.val;
        int rightV = p.val;
        int leftV = q.val;
        if (val < rightV && val < leftV){
            return lowestCommonAncestor(root.right,p,q);
        } else if (val > rightV && val > leftV) {
            return lowestCommonAncestor(root.left , p , q);
        }else {
            return root;
        }
    }
}