package A121v130.A122BestTimetoBuyandSellStockII;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int principal = Integer.MAX_VALUE;
        for (int i = 0; i <= prices.length - 1; i++) {
            int Profit = prices[i] -principal;
            if (Profit<= 0) {
                principal = prices[i];
                continue;
            } else {
                maxProfit = maxProfit + Profit;
                principal = prices[i];
            }
        }
        return maxProfit;
    }
}