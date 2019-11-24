package Offer.a41和为S的连续正数序列;

import java.util.ArrayList;

public class Solution {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        int tmp = 0;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        int left = 1;
        int right = 1;
        while (right < sum) {
            if (tmp + right == sum) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = left; i <= right; i++) {
                    list.add(i);
                }
                res.add(list);
                tmp += right;
                right++;
            } else {
                if (tmp + right < sum) {
                    tmp += right;
                    right++;
                } else {
                    tmp -= left;
                    left++;
                }
            }
        }
        return res;
    }
}