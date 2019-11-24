package A301v500.A368LargestDivisibleSubset;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public  List<Integer> largestDivisibleSubset(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums==null||nums.length==0) {
            return list;
        }
        Arrays.sort(nums);
        int len = nums.length, max, MAX = 0, index = 0;
        int[] dp = new int[len];
        int[] sign = new int[len];
        for (int i = 1; i < len; i++) {
            max = 0;
            sign[i] = i;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && (dp[j] + 1) > max) {
                    max = dp[j];
                    dp[i] = max + 1;
                    sign[i] = j;
                }
            }
            if (MAX < dp[i]) {
                MAX = dp[i];
                index = i;
            }
        }
        while (index != sign[index]) {
            list.add(nums[index]);
            index = sign[index];
        }
        list.add(nums[index]);
        return list;
    }

}