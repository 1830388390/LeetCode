package A231v240.A237DeleteNodeinaLinkedList;

/**
 * Definition for singly-linked list.
 */
class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public void deleteNode(ListNode node) {
        while (node.next != null){
            node.val = node.next.val;
            if (node.next.next == null){
                node.next = null;
                break;
            }
            node = node.next;
        }
    }
}