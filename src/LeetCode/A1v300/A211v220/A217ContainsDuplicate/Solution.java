package LeetCode.A1v300.A211v220.A217ContainsDuplicate;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for (int n : nums){
            if (res.contains(n)){
                return true;
            }else {
                res.add(n);
            }
        }
        return false;
    }
}