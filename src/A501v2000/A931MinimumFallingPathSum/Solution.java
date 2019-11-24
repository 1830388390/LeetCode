package A501v2000.A931MinimumFallingPathSum;

class Solution {
    public int minFallingPathSum(int[][] A) {
        int length = A.length;
        int[][] dp = new int[length + 1][length];

        int res = Integer.MAX_VALUE;
        for (int y = 1; y <= length; y++) {
            for (int x = 0; x < length; x++) {
                if (x == 0) {
                    if (x == length - 1){
                        dp[y][x] = A[y - 1][x] + dp[y - 1][x];
                    }else {
                        dp[y][x] = A[y - 1][x] + Integer.min(dp[y - 1][x], dp[y - 1][x + 1]);
                    }
                } else if (x == length - 1) {
                    dp[y][x] = A[y - 1][x] +Integer.min(dp[y - 1][x], dp[y - 1][x - 1]);
                }else {
                    dp[y][x] = A[y - 1][x] +Integer.min(dp[y - 1][x], Integer.min(dp[y - 1][x + 1], dp[y - 1][x - 1]));
                }

                if (y == length){
                    res = Integer.min(res,dp[y][x]);
                }
            }
        }
        return res;
    }
}