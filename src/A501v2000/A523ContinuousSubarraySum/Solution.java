package A501v2000.A523ContinuousSubarraySum;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer,Integer> sumMod = new HashMap<>();
        int sum = 0;
        sumMod.put(0, -1);
        for (int i =0;i<nums.length;i++){
            sum +=nums[i];
            if (k!=0){
                sum = sum%k;
            }
            if (sumMod.containsKey(sum)){
                if (i-sumMod.get(sum) > 1){
                    return true;
                }
            }else {
                sumMod.put(sum,i);
            }
        }
        return false;
    }
}