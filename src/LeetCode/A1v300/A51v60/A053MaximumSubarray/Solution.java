package LeetCode.A1v300.A51v60.A053MaximumSubarray;

class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int sum = 0;
        for (int num : nums) {
            if (sum > 0){
                sum += num;
            }
            else{
                sum = num;
            }
            res = Math.max(res, sum);
        }
        return res;
    }
}