package A31v40.A037SudokuSolver;

class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] row = new boolean[9][10];
        boolean[][] col = new boolean[9][10];
        boolean[][][] box = new boolean[3][3][10];
        for (int i = 0; i <= board.length - 1; i++) {
            for (int j = 0; j <= board[0].length - 1; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '0';
                    row[i][num] = true;
                    col[j][num] = true;
                    box[i / 3][j / 3][num] = true;
                }
            }
        }
        isNumLegal(board, row, col, box, 0, 0);
    }

    public boolean isNumLegal(char[][] board, boolean[][] row, boolean[][] col, boolean[][][] box, int r, int c) {
        if (c == board[0].length) {
            c = 0;
            if (r == board.length - 1) {
                return true;
            }
            r++;
        }
        if (board[r][c] == '.') {
            for (int n = 1; n <= 9; n++) {
                boolean isExist = row[r][n] || col[c][n] || box[r / 3][c / 3][n];
                if (!isExist) {
                    row[r][n] = true;
                    col[c][n] = true;
                    box[r / 3][c / 3][n] = true;
                    board[r][c] = (char) ('0' + n);
                    if (isNumLegal(board, row, col, box, r, c + 1) == true) {
                        return true;
                    }
                    board[r][c] = '.';
                    row[r][n] = false;
                    col[c][n] = false;
                    box[r / 3][c / 3][n] = false;
                }
                else{
                    continue;
                }
            }
        } else {
            return isNumLegal(board, row, col, box, r, c + 1);
        }

        return false;
    }
}
