package A1v300.A191v200.A199BinaryTreeRightSideView;

import java.util.ArrayList;
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
    List<Integer> res = new ArrayList<>();
    List<List<Integer>> levelTraversal = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null){
            return res;
        }
        makeRes(root,1);
        for (List<Integer> l : levelTraversal){
            res.add(l.get(l.size() - 1));
        }
        return res;
    }

    private void makeRes(TreeNode root,int level){
        if (root == null){
            return;
        }
        if (levelTraversal.size() <level){
            levelTraversal.add(new ArrayList<>());
        }
        levelTraversal.get(level - 1).add(root.val);
        makeRes(root.left,level + 1);
        makeRes(root.right,level + 1);
    }
}