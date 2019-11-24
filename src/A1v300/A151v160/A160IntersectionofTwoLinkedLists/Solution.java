package A1v300.A151v160.A160IntersectionofTwoLinkedLists;

/**
 * Definition for singly-linked list.
 */
public class Solution {
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null){
            return null;
        }
        ListNode headBEndNode = headB;
        while (headBEndNode.next !=null){
            headBEndNode = headBEndNode.next;
        }
        headBEndNode.next = headA;
        int fast = 0;
        int slow = 0;
        ListNode fastNode = headB;
        ListNode slowNode = headB;
        while (true){
            if (fastNode.next == null){
                headBEndNode.next = null;
                return null;
            }
            if (fastNode.next.next == null){
                headBEndNode.next = null;
                return null;
            }
            slowNode = slowNode.next;
            fastNode = fastNode.next.next;
            slow = slow + 1;
            fast = fast + 2;
            if (slowNode == fastNode){
                break;
            }
        }
        int differ = fast - slow;
        fastNode = headB;
        while (differ>0){
            fastNode = fastNode.next;
            differ --;
        }
        slowNode = headB;
        while (slowNode != fastNode){
            slowNode = slowNode.next;
            fastNode = fastNode.next;
        }
        headBEndNode.next = null;
        return slowNode;
    }
}