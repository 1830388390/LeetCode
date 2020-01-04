package LeetCode.A1v300.A51v60.A059SpiralMatrixII;

class Solution {
    public int[][] generateMatrix(int n) {

        if (n == 0) {
            return null;
        }
        int[][] res = new int[n][n];
        int[] directionX = new int[]{1, 0, -1, 0};
        int[] directionY = new int[]{0, 1, 0, -1};
        int x = 0;
        int y = 0;
        int changeD = 0;
        for (int i = 1; i <= n * n; i++) {
            res[y][x] = i;
            if (x + directionX[changeD] <= n - 1
                    && x + directionX[changeD] >= 0
                    && y + directionY[changeD] <= n - 1
                    && y + directionY[changeD] >= 0
                    && res[y + directionY[changeD]][x + directionX[changeD]] == 0) {
                x = x + directionX[changeD];
                y = y + directionY[changeD];
                continue;
            } else {
                changeD++;
                changeD = changeD % 4;
                x = x + directionX[changeD];
                y = y + directionY[changeD];
                continue;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().generateMatrix(3);
    }
}