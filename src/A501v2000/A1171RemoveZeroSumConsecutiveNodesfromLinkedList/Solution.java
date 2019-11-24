package A501v2000.A1171RemoveZeroSumConsecutiveNodesfromLinkedList;

import java.util.HashMap;
import java.util.Map;

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

    public ListNode removeZeroSumSublists(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode tmp = dummy;
        Map<Integer, ListNode> prefixSum = new HashMap<>();
        int sum = 0;
        while (tmp != null) {
            sum += tmp.val;
            if (prefixSum.containsKey(sum)){
                prefixSum.get(sum).next = tmp.next;
            }else {
                prefixSum.put(sum,tmp);
            }
            tmp = tmp.next;
        }
        return dummy.next;
    }
}