package LeetCode.A1v300.A201v210.A208PrefixTree;

import java.util.HashMap;
import java.util.Map;

class Trie {

    class Node{
        Map<Character,Node> nextNodes = new HashMap<>();
        boolean isWord = false;
    }

    Node node;
    /** Initialize your data structure here. */
    public Trie() {
        this.node = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = node;
        for (int i = 0;i<word.length();i++){
            char tmp = word.charAt(i);
            if (cur.nextNodes.containsKey(tmp)){
                cur = cur.nextNodes.get(tmp);
            }else {
                cur.nextNodes.put(tmp,new Node());
                cur = cur.nextNodes.get(tmp);
            }
            if (i == word.length() - 1){
                cur.isWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = node;
        for (int i = 0;i<word.length();i++){
            char tmp = word.charAt(i);
            if (cur.nextNodes.containsKey(tmp)){
                cur = cur.nextNodes.get(tmp);
            }else {
                return false;
            }
        }
        return cur.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = node;
        for (int i = 0;i<prefix.length();i++){
            char tmp = prefix.charAt(i);
            if (cur.nextNodes.containsKey(tmp)){
                cur = cur.nextNodes.get(tmp);
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        new Trie().insert("apple");
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */