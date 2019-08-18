package A257BinaryTreePaths;

import java.util.ArrayList;
import java.util.List;

class binaryTreePaths {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }


    static class Solution {
        String leftnode = "";
        String rightnode = "";

        public String leftnode(TreeNode root) {
            if (root != null) {
                if (root.left != null) {
                    if (leftnode == "") {
                        leftnode += root.val;
                    }
                    root = root.left;
                } else {
                    if(root.right!=null&&leftnode!= "") {
                        leftnode += "->" + root.right.val;
                    }
                    return leftnode;
                }
                leftnode += "->" + root.val;
                leftnode(root);

            }
            return leftnode;
        }

        public String rightnode(TreeNode root) {
            if (root != null) {
                if (root.right != null) {
                    if (rightnode == "") {
                        rightnode += root.val;
                    }
                    root = root.right;
                } else {
                    if(root.left!=null&&rightnode!= "") {
                        rightnode += "->" + root.left.val;
                    }
                    return rightnode;
                }
                rightnode += "->" + root.val;
                rightnode(root);
            }
            return rightnode;
        }

        public List<String> binaryTreePaths(TreeNode root) {
            List<String> list = new ArrayList<>();

            if (root == null) {
                return list;
            }
            if (root.left == null && root.right == null) {
                list.add(String.valueOf(root.val));
                return list;
            }
            leftnode(root);
            rightnode(root);
            if(leftnode != "") {
                list.add(leftnode);
            }
            if(rightnode != "") {
                list.add(rightnode);
            }
            return list;

        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.left.right=new TreeNode(5);
        treeNode.right=new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.binaryTreePaths(treeNode));
    }

}
