package LeetCode.A1v300.A131v140.A137SingleNumberII;

class Solution {
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];

        for (int j = 0; j < 32; j++) {
            for (int i = 0; i < nums.length; i++) {
                int num = nums[i] >> j;
                bit[j] += num & 1;
            }
        }

        int result = 0;
        for (int i = 31; i >= 0; i--) {
            result <<= 1;
            result += bit[i] % 3;
        }
        return result;
    }
}