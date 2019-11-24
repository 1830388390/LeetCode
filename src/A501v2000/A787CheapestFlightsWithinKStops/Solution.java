package A501v2000.A787CheapestFlightsWithinKStops;

import javafx.util.Pair;

import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
        List<Set<Pair<Integer, Integer>>> graph = new ArrayList<>();
        for (int i = 0;i<n;i++){
            graph.add(new HashSet<>());
        }
        for (int[] tmp : flights){
            graph.get(tmp[0]).add(new Pair<>(tmp[1],tmp[2]));
        }
        int cost = Integer.MAX_VALUE;
        Queue<int[]> route = new LinkedList<>();
        for (Pair<Integer, Integer> tmp : graph.get(src)){
            route.add(new int[]{tmp.getKey(),tmp.getValue(),0});
        }
        while (!route.isEmpty()){
            int[] node = route.poll();
            int tmpDst = node[0];
            int tmpCost = node[1];
            int tmpTime = node[2];
            if (tmpTime > K){
                break;
            }
            if (tmpDst == dst){
                cost = Integer.min(cost,tmpCost);
            }else {
                for (Pair<Integer, Integer> tmp : graph.get(tmpDst)){
                    int nextDst = tmp.getKey();
                    int addCost = tmp.getValue();
                    if (addCost+tmpCost < cost){
                        route.add(new int[]{nextDst,addCost+tmpCost,tmpTime + 1});
                    }
                }
            }
        }
        return cost == Integer.MAX_VALUE ? -1: cost;
    }
    /**
     * 3
     * [[0,1,100],[1,2,100],[0,2,500]]
     * 0
     * 2
     * 1
     */
    public static void main(String[] args) {
        new Solution().findCheapestPrice(3,new int[][]{{0,1,100},{1,2,100},{0,2,500}},0,2,1);
    }
}