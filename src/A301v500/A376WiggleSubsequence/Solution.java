package A301v500.A376WiggleSubsequence;

class Solution {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (length<= 2){
            return length;
        }
        int up = 1;
        int down = 1;
        for (int i=1;i<length;i++){
            if (nums[i]>nums[i - 1]){
                up = down + 1;
            }else if (nums[i] < nums[i - 1]){
                down = up + 1;
            }
        }
        return down>up ? down : up;
    }

}