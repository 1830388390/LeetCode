package A501v2000.A1140StoneGameII;

class Solution {
    int[] sum;
    int[][] dp;

    public int stoneGameII(int[] piles) {
        int length = piles.length;
        sum = new int[length];
        sum[length - 1] = piles[length - 1];
        dp = new int[length][length/2 + 1];
        for (int i = length - 2; i >=0; i--) {
            sum[i] = piles[i] + sum[i + 1];
        }
        return makeRes(0,length,1);
    }

    private int makeRes(int start,int end,int M){
        if (start >= end){
            return 0;
        }

        if (start+2*M >= end){
            return sum[start];
        }

        if (dp[start][M] != 0){
            return dp[start][M];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 1;i<=2*M;i++){
            res = Integer.min(res,makeRes(start+i,end,Math.max(M,i)));
        }

        dp[start][M] = sum[start] - res;
        return sum[start] - res;
    }

    public static void main(String[] args) {
        new Solution().stoneGameII(new int[]{2,7,9,4,4});
    }
}