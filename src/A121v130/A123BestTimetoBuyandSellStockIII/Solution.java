package A121v130.A123BestTimetoBuyandSellStockIII;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

class Solution {
    static Comparator<Integer> cmp = new Comparator<Integer>() {
        @Override
        public int compare(Integer e1, Integer e2) {
            return e2 - e1;
        }
    };
    public int maxProfit(int[] prices) {
        Queue<Integer> maxProfitQueue = new PriorityQueue<>();
        int maxProfit = 0;
        int principal = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i <= prices.length - 1; i++) {
            int Profit = prices[i] -principal;
            if (Profit<= 0) {

                maxProfit = 0;
                principal = prices[i];
                continue;
            } else {
                maxProfit = maxProfit + Profit;
                maxProfitQueue.add(maxProfit);
                principal = prices[i];
            }
        }
        int i = 0;
        while (!maxProfitQueue.isEmpty() && i<2){
            res = res + maxProfitQueue.poll();
            i++;
        }
        return res;
    }
}