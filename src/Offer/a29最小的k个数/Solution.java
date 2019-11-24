package Offer.a29最小的k个数;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        if (k>input.length){
            return new ArrayList<>();
        }
        Queue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a));
        for (int i : input) {
            pq.add(i);
        }
        ArrayList<Integer> res = new ArrayList<>();
        while (k > 0) {
            res.add(pq.remove());
            k--;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().GetLeastNumbers_Solution(new int[]{4,5,1,6,2,7,3,8},4);
    }
}