package LeetCode.A1v300.A211v220.A219ContainsDuplicateII;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer,Integer> tmp = new HashMap<>();
        for (int i = 0;i<nums.length;i++){
            if (tmp.containsKey(nums[i])){
                if ( i -tmp.get(nums[i])<=k){
                    return true;
                }else {
                    tmp.put(nums[i],i);
                }
            }else {
                tmp.put(nums[i],i);
            }
        }
        return false;
    }
}