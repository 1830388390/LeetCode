package A1v300.A141v150.A142LinkedListCycleII;

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

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode slowNode = head;
        ListNode fastNode = head;
        int slowPath = 0;
        int fastPath = 0;
        int differ = 0;
        while (true) {
            if (slowNode.next == null) {
                return null;
            }
            if (fastNode.next == null || fastNode.next.next == null) {
                return null;
            }
            slowNode = slowNode.next;
            slowPath = slowPath + 1;
            fastNode = fastNode.next.next;
            fastPath = fastPath + 2;
            if (slowNode == fastNode) {
                differ = fastPath - slowPath;
                break;
            }
        }
        slowNode = head;
        fastNode = head;
        for (int i = 0; i < differ; i++) {
            fastNode = fastNode.next;
        }
        while (slowNode != fastNode){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        return slowNode;
    }
}