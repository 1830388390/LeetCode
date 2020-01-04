package LeetCode.A301v500.A494TargetSum;

class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        makeRes(nums,0,0,S);
        return res;
    }

    private void makeRes(int[] nums,int index,int cur,int S){
        if (index == nums.length){
            if (cur == S){
                res++;
                return;
            }else {
                return;
            }
        }
        makeRes(nums, index+1, cur + nums[index], S);
        makeRes(nums, index+1, cur - nums[index], S);
    }
}

class Solution2 {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if(sum < target || (sum+target)%2 == 1){
            return 0;
        }
        target = (target + sum) >> 1;
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                dp[i] += dp[i - num];
            }
        }
        return dp[target];
    }
}