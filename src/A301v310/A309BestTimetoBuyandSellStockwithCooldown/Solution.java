package A301v310.A309BestTimetoBuyandSellStockwithCooldown;

class Solution {
    public int maxProfit(int[] prices) {
        int day = prices.length;
        if (day == 0){
            return 0;
        }
        int[][] res = new int[day][2];
        res[0][0] = 0;
        res[0][1] = -prices[0];
        for (int i = 1;i<day;i++){
            res[i][0] = Integer.max(res[i - 1][0],res[i - 1][1] + prices[i]);
            if (i>=2){
                res[i][1] = Integer.max(res[i - 2][0] - prices[i],res[i - 1][1]);
            }else {
                res[i][1] = Integer.max(res[i - 1][0] - prices[i],res[i - 1][1]);
            }
        }
        return res[day - 1][0];
    }
}