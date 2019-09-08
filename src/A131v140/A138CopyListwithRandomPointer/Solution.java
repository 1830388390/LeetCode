package A131v140.A138CopyListwithRandomPointer;

import java.util.HashMap;
import java.util.Map;

/*
// Definition for a Node.

*/
class Solution {

    static class Node {
        public int val;
        public Node next;
        public Node random;

        public Node(int i) {
            this.val = i;
        }

        public Node(int _val,Node _next,Node _random) {
            val = _val;
            next = _next;
            random = _random;
        }

        public Node() {

        }
    }

    public Node copyRandomList(Node head) {
        Map<Integer,Node> nodes = new HashMap<>();
        return makeRes(head,nodes);
    }

    private Node makeRes(Node head, Map<Integer,Node> nodes){
        if (head == null ||nodes.containsKey(head.val)){
            return head == null ? null :nodes.get(head.val);
        }
        Node node = new Node(1);
        node.val = head.val;
        nodes.put(head.val,node);
        node.next = makeRes(head.next,nodes);
        node.random = makeRes(head.random,nodes);
        return node;
    }
    private Map makeRes2(Node head){
        Map<Integer,Node> nodes = new HashMap<>();
        Node node = new Node();
        node.val = head.val;
        nodes.put(head.val,node);
        node.next = new Node(1);
        node.random = new Node(2);
        return nodes;
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        Map<Integer,Node> nodes = new Solution().makeRes2(node);
        System.out.println(nodes.get(node.val).next.val);
    }
}