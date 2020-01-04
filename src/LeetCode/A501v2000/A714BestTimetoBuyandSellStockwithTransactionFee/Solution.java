package LeetCode.A501v2000.A714BestTimetoBuyandSellStockwithTransactionFee;

class Solution {
    public int maxProfit(int[] prices, int fee) {
        int[][] res = new int[prices.length][2];
        res[0][0] = 0;
        res[0][1] = prices[0];
        for (int i = 1;i<prices.length;i++){
            res[i][0] = Integer.max(res[i - 1][0],res[i - 1][1] + prices[i] - fee);
            res[i][1] = Integer.max(res[i - 1][1],res[i - 1][0] - prices[i]);
        }
        return res[prices.length - 1][0];
    }
}