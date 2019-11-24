package Offer.a14链表中倒数第k个节点;


/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head, int k) {
        ListNode tmp = head;
        while (k != 0) {
            if (tmp == null && k != 0) {
                return null;
            }
            tmp = tmp.next;
            k--;

        }
        while (tmp != null) {
            head = head.next;
            tmp = tmp.next;
        }
        return head;
    }
}