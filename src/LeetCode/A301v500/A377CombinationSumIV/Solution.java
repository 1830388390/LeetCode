package LeetCode.A301v500.A377CombinationSumIV;

class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] res = new int[target + 1];
        res[0] = 1;
        for (int i = 1; i <= target; i++) {
            for (int n : nums) {
                if (i >= n) {
                    res[i]  =res[i] + res[i - n];
                }
            }
        }
        return res[target];
    }
}