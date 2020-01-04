package LeetCode.A1v300.A131v140.A133CloneGraph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Solution {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
        }

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        Map<Integer, Node> map = new HashMap<>();
        return cloneGrapthHelper(node, map);
    }

    private Node cloneGrapthHelper(Node node, Map<Integer, Node> map) {
        if (map.containsKey(node.val)){
            return map.get(node.val);
        }
        Node cloneNode = new Node();
        cloneNode.val = node.val;
        cloneNode.neighbors = new ArrayList<>();
        map.put(cloneNode.val,cloneNode);
        for (Node n : node.neighbors){
            cloneNode.neighbors.add(cloneGrapthHelper(n,map));
        }
        return cloneNode;
    }
}