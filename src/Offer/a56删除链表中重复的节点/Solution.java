package Offer.a56删除链表中重复的节点;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，
 * 重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return pHead;
        }
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = pHead;
        ListNode fast = dummyHead.next;
        ListNode slow = dummyHead;
        while (slow.next != null) {
            if (fast.next != null && fast.next.val == fast.val) {
                while (fast.next != null && fast.next.val == fast.val) {
                    fast = fast.next;
                }
                fast = fast.next;
                slow.next = fast;
            } else {
                slow = slow.next;
                fast = fast.next;
            }
        }
        return dummyHead.next;
    }
}