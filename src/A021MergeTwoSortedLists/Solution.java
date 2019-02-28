package A021MergeTwoSortedLists;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode curl1 = l1;
        ListNode curl2 = l2;
        ListNode dummyhead = new ListNode(1);
        ListNode curdummy = dummyhead;
        while (true) {
            if (curl1 == null) {
                curdummy.next = curl2;
                return dummyhead.next;
            } else if (curl2 == null) {
                curdummy.next = curl1;
                return dummyhead.next;
            } else if (curl1.val >= curl2.val) {
                curdummy.next = curl2;
                curdummy = curdummy.next;
                curl2 = curl2.next;
            } else {
                curdummy.next = curl1;
                curdummy = curdummy.next;
                curl1 = curl1.next;
            }
        }
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}