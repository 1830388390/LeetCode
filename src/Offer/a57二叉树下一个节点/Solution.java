package Offer.a57二叉树下一个节点;

/*

 */
public class Solution {
    public class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) {
            return null;
        }
        if (pNode.right != null) {
            pNode = pNode.right;
            while (pNode.left != null) {
                pNode = pNode.left;
            }
            return pNode;
        }
        while (pNode != null) {
            TreeLinkNode parent = pNode.next;
            if (parent == null){
                return null;
            }
            if (pNode == pNode.next.left) {
                return pNode.next;
            } else {
                pNode = parent;
            }
        }
        return null;
    }
}