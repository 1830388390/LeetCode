package LeetCode.A1v300.A61v70.A062UniquePaths;

class Solution {

    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] times = new int[m][n];
        for (int i = 0; i <= m - 1; i++) {
            times[i][0] = 1;
        }
        for (int i = 0; i <= n - 1; i++) {
            times[0][i] = 1;
        }
        int x = 1;
        int y = 1;
        while (x <= n - 1) {
            times[y][x] = times[y - 1][x] + times[y][x - 1];
            y++;
            if (y == m){
                y = 1;
                x++;
            }
        }
        return times[m - 1][n - 1];
    }

}