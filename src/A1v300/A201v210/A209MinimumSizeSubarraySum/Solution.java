package A1v300.A201v210.A209MinimumSizeSubarraySum;

class Solution {
    private int res = Integer.MAX_VALUE;
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null) {
            return 0;
        }
        int left = 0;
        int right = 0;
        int sum = 0;
        while(right < nums.length){
            sum += nums[right];
            while(left <= right && sum >= s){
                res = Math.min(res,right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

    public static void main(String[] args) {
        new Solution().minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }
}