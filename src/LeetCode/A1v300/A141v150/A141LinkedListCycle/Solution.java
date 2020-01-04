package LeetCode.A1v300.A141v150.A141LinkedListCycle;

/**
 * Definition for singly-linked list.
 */
public class Solution {
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        while (true) {
            if (slowNode.next == null) {
                return false;
            }
            if (fastNode.next == null || fastNode.next.next == null) {
                return false;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            if (slowNode == fastNode){
                return true;
            }
        }
    }
}