package Offer.a55链表中的入口节点;

/*

 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null || pHead.next == null) {
            return null;
        }
        ListNode fast = pHead.next.next;
        ListNode slow = pHead.next;
        int a = 1;
        int b = 2;
        while (fast != slow) {
            if (slow.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            a++;
            b += 2;
        }
        int dif = b - a;
        fast = pHead;
        slow = pHead;
        for (int i = 1; i <= dif; i++) {
            fast = fast.next;
        }
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }
}