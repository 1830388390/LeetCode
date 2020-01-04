package LeetCode.A1v300.A71v80.A073SetMatrixZeroes;

class Solution {
    public void setZeroes(int[][] matrix) {
        int y = matrix.length;
        int x = matrix[0].length;
        boolean firstRow = false;
        boolean firstCol = false;
        for (int i = 0; i <= y - 1; i++) {
            for (int j = 0; j <= x - 1; j++) {
                if (matrix[i][j] == 0) {
                    if (i == 0){
                        firstRow = true;
                    }
                    if (j == 0){
                        firstCol = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i <= y - 1; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j <= x - 1; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i <= x - 1; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j <= y - 1; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if (firstCol) {
            for (int i = 0; i <= y - 1; i++) {
                matrix[i][0] = 0;
            }}
        if (firstRow){
            for (int i = 0; i <= x - 1; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}

