package A51v60.A055JumpGame;

class Solution {
    public boolean canJump(int[] nums) {
        int l = nums.length;
        if (l == 1){
            return true;
        }
        boolean[] canJp = new boolean[l];
        for (int i = l -1;i>=0;i--){
            if (nums[i] == 0){
                canJp[i] = false;
                continue;
            }
            if (i + nums[i] >=nums.length - 1){
                canJp[i] = true;
                continue;
            }
            for (int j = i;j<=i + nums[i];j ++){
                if (canJp[j] == true){
                    canJp[i] = true;
                    break;
                }
            }
        }
        return canJp[0];
    }

    public static void main(String[] args) {
        new Solution().canJump(new int[]{3,2,1,0,4});
    }
}