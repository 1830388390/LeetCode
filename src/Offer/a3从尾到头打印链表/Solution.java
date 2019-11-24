package Offer.a3从尾到头打印链表;

/**
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 */

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        while (listNode != null) {
            res.add(listNode.val);
            listNode = listNode.next;
        }
        int start = 0;
        int end = res.size() - 1;
        while (start < end) {
            int tmp = res.get(start);
            res.set(start, res.get(end));
            res.set(end, tmp);
            start++;
            end--;
        }
        return res;
    }
}