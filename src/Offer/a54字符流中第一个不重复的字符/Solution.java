package Offer.a54字符流中第一个不重复的字符;

public class Solution {
    class Node {
        Node pro;
        Node next;
        char val;

        public Node(Node pro, Node next, char val) {
            this.pro = pro;
            this.next = next;
            this.val = val;
        }
    }

    Node[] words;
    Node dummyHead;
    Node dummyTail;

    {
        words = new Node[127];
        dummyHead = new Node(null, null, '#');
        dummyTail = new Node(dummyHead, null, '#');
        dummyHead.next = dummyTail;
        for (int i = 0; i < words.length; i++) {
            words[i] = null;
        }
    }

    //Insert one char from stringstream
    public void Insert(char ch) {
        if (words[ch] == null) {
            Node node = new Node(dummyTail.pro, dummyTail, ch);
            dummyTail.pro.next = node;
            dummyTail.pro = node;
            words[ch] = node;
        } else {
            Node node = words[ch];
            if (node.val != '#') {
                Node pro = node.pro;
                Node next = node.next;
                pro.next = next;
                next.pro = pro;
                node.val = '#';
            }
        }
    }

    //return the first appearence once char in current stringstream
    public char FirstAppearingOnce() {
        return dummyHead.next.val;
    }
}