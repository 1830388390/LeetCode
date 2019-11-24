package Offer.a25复杂链表的复制;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，
 * 一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。
 * （注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    Map<Integer,RandomListNode> map = new HashMap<>();
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null || map.containsKey(pHead.label)){
            return pHead == null ? null : map.get(pHead.label);
        }

        RandomListNode root = new RandomListNode(0);
        root.label = pHead.label;
        map.put(pHead.label,root);
        root.next = Clone(pHead.next);
        root.random = Clone(pHead.random);
        return root;
    }
}