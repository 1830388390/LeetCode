package LeetCode.A1v300.A61v70.A061RotateList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null){
            return head;
        }
        ListNode dummyNode = head;
        ListNode dummyHead = head;
        int l = 0;
        while (dummyHead != null) {
            dummyHead = dummyHead.next;
            l++;
        }
        k = k % l;
        if (k == 0) {
            return head;
        }

        for (int i = 1; i <= k; i++) {
            dummyNode = dummyNode.next;
        }

        ListNode lastNode = head;
        while (dummyNode.next != null) {
            dummyNode = dummyNode.next;
            lastNode = lastNode.next;
        }
        ListNode root = lastNode.next;
        lastNode.next = null;
        dummyNode.next = head;
        return root;
    }
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        new Solution().rotateRight(head,1);
    }
}