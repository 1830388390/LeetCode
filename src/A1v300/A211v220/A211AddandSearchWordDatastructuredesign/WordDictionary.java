package A1v300.A211v220.A211AddandSearchWordDatastructuredesign;

import java.util.Objects;

class WordDictionary {
    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public WordDictionary() {
        root = new TrieNode('-');
    }

    /**
     * Adds a word into the data structure.
     */
    public void addWord(String word) {
        int length = word.length();
        TrieNode node = root;

        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);
            int position = c - 'a';

            if (node.children[position] == null) {
                node.children[position] = new TrieNode(c);
            }
            node = node.children[position];
        }
        node.children[26] = new TrieNode('0');
    }

    /**
     * Returns if the word is in the data structure. A word could contain the dot character '.' to
     * represent any one letter.
     */
    public boolean search(String word) {
        return search(word, root);
    }

    public boolean search(String word, TrieNode node) {
        if (Objects.equals("", word)) {
            if (node.children[26] != null) {
                return true;
            } else {
                return false;
            }
        }

        int length = word.length();

        for (int i = 0; i < length; i++) {
            char c = word.charAt(i);

            if (c == '.') {
                for (int j = 0; j < 26; j++) {
                    if (node.children[j] != null) {
                        String str = word.substring(i + 1);

                        if (search(str, node.children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                int position = c - 'a';

                if (node.children[position] == null) {
                    return false;
                } else {
                    node = node.children[position];
                }
            }

            if (i == length - 1) {
                if (node.children[26] != null) {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private class TrieNode {
        char val;
        TrieNode[] children;

        public TrieNode(char val) {
            this.val = val;
            children = new TrieNode[27];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */