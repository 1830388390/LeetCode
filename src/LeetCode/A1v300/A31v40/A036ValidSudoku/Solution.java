package LeetCode.A1v300.A31v40.A036ValidSudoku;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean res = true;
        Map<Integer, ArrayList<Character>> row = new HashMap<>(9);
        Map<Integer, ArrayList<Character>> column = new HashMap<>(9);
        Map<Integer, ArrayList<Character>> lattice = new HashMap<>(9);
        int length = board[0].length;
        for (int i = 0; i <= length - 1; i++) {
            for (int j = 0; j <= length - 1; j++) {
                if (board[i][j] != '.' && column.containsKey(i)) {
                    ArrayList<Character> c = column.get(i);
                    if (c.contains(board[i][j])) {
                        return false;
                    } else {
                        c.add(board[i][j]);
                    }
                }
                if (board[j][i] != '.' && row.containsKey(j)) {
                    ArrayList<Character> r = row.get(j);
                    if (r.contains(board[j][i])) {
                        return false;
                    } else {
                        r.add(board[j][i]);
                    }
                }
                int index = (i / 3 ) * 3 + j / 3;
                if (board[i][j] != '.' && lattice.containsKey(index)) {
                    ArrayList<Character> l = lattice.get(index);
                    if (l.contains(board[i][j])) {
                        return false;
                    } else {
                        l.add(board[i][j]);
                    }
                }
            }
        }
        return res;
    }
}
class Solution2 {
    public boolean isValidSudoku(char[][] board) {
        // init data
        HashMap<Integer, Integer> [] rows = new HashMap[9];
        HashMap<Integer, Integer> [] columns = new HashMap[9];
        HashMap<Integer, Integer> [] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<Integer, Integer>();
            columns[i] = new HashMap<Integer, Integer>();
            boxes[i] = new HashMap<Integer, Integer>();
        }

        // validate a board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int n = (int)num;
                    int box_index = (i / 3 ) * 3 + j / 3;

                    // keep the current cell value
                    rows[i].put(n, rows[i].getOrDefault(n, 0) + 1);
                    columns[j].put(n, columns[j].getOrDefault(n, 0) + 1);
                    boxes[box_index].put(n, boxes[box_index].getOrDefault(n, 0) + 1);

                    // check if this value has been already seen before
                    if (rows[i].get(n) > 1 || columns[j].get(n) > 1 || boxes[box_index].get(n) > 1)
                        return false;
                }
            }
        }

        return true;
    }
}
