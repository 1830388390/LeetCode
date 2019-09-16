package A211v220.A212WordSearchII;

import java.util.*;

class Solution {
    Set<String> res = new HashSet<>();
    int height = 0;
    int wide = 0;
    char[][] board;

    public List<String> findWords(char[][] board, String[] words) {
        this.height = board.length;
        if (height == 0) {
            return new ArrayList<>();
        }
        this.board = board;
        this.wide = board[0].length;
        for (String w : words){
            find(w);
        }
        return new ArrayList<>(res);
    }

    public void find(String word){
        boolean[][] isUsed = new boolean[height][wide];
        int x = 0;
        int y = 0;
        while (y<height){
            if (makeRes(y,x,word,0,isUsed)){
                return;
            }else {
                x++;
                if (x==wide){
                    x = 0;
                    y++;
                }
                makeRes(y,x,word,0,isUsed);
            }
        }
    }

    public boolean makeRes(int y, int x, String word, int index,boolean[][] isUsed) {
        if (index == word.length()) {
            res.add(word);
            return true;
        }
        if (y >= height || y < 0 || x >= wide || x < 0) {
            return false;
        }
        if (word.charAt(index) == board[y][x] && !isUsed[y][x]) {
            isUsed[y][x] = true;
            makeRes(y + 1, x, word, index + 1,isUsed);
            makeRes(y, x + 1, word, index + 1,isUsed);
            makeRes(y - 1, x, word, index + 1,isUsed);
            makeRes(y, x - 1, word, index + 1,isUsed);
            isUsed[y][x] = false;
        } else {
            return false;
        }
        return false;
    }
}

class Solution2 {
    private TrieNode root= new TrieNode(' '); // initialize a TrieTree structure
    private boolean[][] used;
    private int board_width, word_len, board_length;
    private Set<String> res= new TreeSet<>(); //use treeSet sort word

    private static class TrieNode {
        static final int CHAR_NUM= 26;
        private char val;
        private boolean isWord= false;
        private TrieNode[] children= new TrieNode[CHAR_NUM];
        private TrieNode(){}
        private TrieNode(char c) {
            TrieNode node=new TrieNode();
            node.val= c;
        }
    }

    /** Inserts a word into the trie. */
    private void insert(String word) {
        TrieNode curr= root;
        for (int i=0; i<word.length(); i++) {
            char c= word.charAt(i);
            if (curr.children[c-'a']==null)
                curr.children[c-'a']= new TrieNode(c);
            curr= curr.children[c-'a'];
        }
        curr.isWord= true;
    }

    public List<String> findWords(char[][] board, String[] words) {
        if (words.length==0)
            return new LinkedList<String>();

        for (String word: words)
            insert(word);
        board_length= board.length;
        board_width= board[0].length;
        used = new boolean[board_length][board_width];

        for (int i=0; i<board_length; i++)
            for (int j=0; j<board_width; j++)
                dfs( i, j, board, new StringBuilder(), root, used);
        return new LinkedList<String>(res);
    }

    private void dfs(int line, int row, char[][] board, StringBuilder sb,
                     TrieNode currNode, boolean[][] used) {

        if (line<0 || line>=board_length || row<0 || row>=board_width)
            return;
        if (used[line][row])
            return;
        if (currNode.children[board[line][row]-'a']==null)
            return;
        sb.append(board[line][row]);
        currNode= currNode.children[board[line][row]-'a'];
        if (currNode.isWord)
            res.add(sb.toString());

        used[line][row]= true;
        dfs(line-1, row, board, sb, currNode, used);
        dfs(line+1, row, board, sb, currNode, used);
        dfs(line, row-1, board, sb, currNode, used);
        dfs(line, row+1, board, sb, currNode, used);
        sb.deleteCharAt(sb.length()-1);  // recover StringBuilder for next dfs
        used[line][row]= false;	// recover boolean[][] used for next dfs
    }
}