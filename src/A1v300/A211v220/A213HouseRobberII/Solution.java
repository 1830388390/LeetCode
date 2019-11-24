package A1v300.A211v220.A213HouseRobberII;

class Solution {
    public int rob(int[] nums) {
        int length = nums.length;
        if (length <= 1){
            return length == 1? nums[0] : 0;
        }
        return Integer.max(makeRes(nums,0,length - 2),makeRes(nums,1,length - 1));
    }
    public int makeRes(int[] nums,int l,int r){
        int first = 0;
        int cur = 0;
        while (l<=r){
            int tmp = cur;
            cur = Integer.max(nums[l] + first,cur);
            first = tmp;
            l++;
        }
        return cur;
    }
}