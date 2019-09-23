package A181v190.A188BestTimetoBuyandSellStockIV;

import static java.lang.Math.max;

class Solution {
    public int maxProfit(int k, int[] prices) {
        int day = prices.length;
        if (day == 0){
            return 0;
        }
        if (prices.length/2>=k){
            return getResIncludeK(k, prices);
        }else {
            return getResExcludeK(prices);
        }

    }

    private int getResExcludeK(int[] prices){
        int day = prices.length;
        int[][] res = new int[day][2];
        res[0][0] = 0;
        res[0][1] = -prices[0];
        for (int i = 1;i<day;i++){
            res[i][0] = Integer.max(res[i - 1][0],res[i - 1][1] + prices[i]);
            res[i][1] = Integer.max(res[i - 1][1],res[i - 1][0] - prices[i]);
        }
        return res[day -1][0];
    }

    private int getResIncludeK(int k,int[] prices){
        int day = prices.length;
        int[][][] res = new int[day][k + 1][2];
        for (int i = 0; i < k + 1; i++) {
            res[0][i][0] = 0;
            res[0][i][1] = -prices[0];
        }
        for (int i = 1; i < day; i++) {
            for (int j = 1;j<k+1;j++){
                res[i][j][0] = Integer.max(res[i - 1][j][0],res[i - 1][j][1] + prices[i]);
                res[i][j][1] = Integer.max(res[i - 1][j][1],res[i - 1][j - 1][0] - prices[i]);
            }
        }
        return res[day - 1][k][0];
    }
}