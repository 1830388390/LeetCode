package LeetCode.A1v300.A161v170.A169MajorityElement;

class Solution {
    public int majorityElement(int[] nums) {
        int res = 0;
        int vote = 0;
        for (int n : nums){
            if (vote == 0){
                res = n;
                vote = 1;
            }else {
                if (n == res){
                    vote ++;
                }else {
                    vote --;
                }
            }
        }
        return res;
    }
}