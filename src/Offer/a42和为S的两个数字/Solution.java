package Offer.a42和为S的两个数字;

import java.util.ArrayList;
public class Solution {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            if (array[start] + array[end] == sum) {
                ArrayList<Integer> res = new ArrayList<>();
                res.add(array[start]);
                res.add(array[end]);
                return res;
            } else if (array[start] + array[end] > sum) {
                end--;
            } else {
                start++;
            }
        }
        return new ArrayList<>();
    }
}