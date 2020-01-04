package Offer.a65矩阵中的路径;

public class Solution {
    char[] matrix;
    char[] str;
    int height;
    int wide;

    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        this.matrix = matrix;
        this.str = str;
        this.height = rows;
        this.wide = cols;
        boolean[][] isUsed = new boolean[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (makeRes(isUsed, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean makeRes(boolean[][] isUsed, int index, int y, int x) {
        if (index == str.length) {
            return true;
        }
        if (isUsed[y][x] == true || y < 0 || y >= height || x < 0 || x > wide) {
            return false;
        }
        if (matrix[wide * y + x] == str[index]) {
            isUsed[y][x] = true;
            index++;
            boolean res = makeRes(isUsed, index, y + 1, x) ||
                    makeRes(isUsed, index, y, x + 1) ||
                    makeRes(isUsed, index, y - 1, x) ||
                    makeRes(isUsed, index, y, x - 1);
            isUsed[y][x] = false;
            return res;
        }
        return false;
    }
}