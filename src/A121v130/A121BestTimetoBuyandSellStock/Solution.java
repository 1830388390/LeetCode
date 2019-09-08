package A121v130.A121BestTimetoBuyandSellStock;

class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int principal = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i <= prices.length - 1; i++) {
            int Profit = prices[i] -principal;
            if (maxProfit + Profit <= 0) {
                principal = prices[i];
                maxProfit = 0;
                continue;
            } else {
                maxProfit = maxProfit + Profit;
                res = Integer.max(maxProfit, res);
                principal = prices[i];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().maxProfit(new int[]{7,1,5,3,6,4});
    }
}