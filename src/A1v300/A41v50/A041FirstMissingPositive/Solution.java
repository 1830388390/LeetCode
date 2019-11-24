package A1v300.A41v50.A041FirstMissingPositive;

class Solution {
    public int firstMissingPositive(int[] nums) {
        int l = nums.length;
        if (nums.length == 0){
            return 1;
        }
        boolean isHaveOne = false;
        for (int i = 0; i <= l - 1; i++) {
            int n = nums[i];
            if (n == 1) {
                isHaveOne = true;
            }
            if (n > l || n <= 0) {
                nums[i] = 1;
            }
        }
        if (!isHaveOne) {
            return 1;
        }
        for (int j = 0; j <= l - 1; j++) {
            int n = Math.abs(nums[j]);
            if (n == l) {
                nums[0] = -Math.abs(nums[0]);
            } else {
                nums[n] = -Math.abs(nums[n]);
            }
        }
        for (int k = 1; k <= l - 1; k++) {
            if (nums[k] > 0) {
                return k;
            }
        }
        if (nums[0] > 0) {
            return l;
        }else {
            return l + 1;
        }

    }

    public static void main(String[] args) {
        new Solution().firstMissingPositive(new int[]{2,1});
    }
}