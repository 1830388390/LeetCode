package A501v2000.A1248CountNumberofNiceSubarrays;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int right = 0;
        int res = 0;
        while (right < nums.length) {
            if (nums[right] % 2 == 1) {
                count++;
                right++;
            } else {
                right++;
            }
            if (count == k) {
                int i = 1;
                int j = 1;
                while (right < nums.length && nums[right] % 2 != 1) {
                    right++;
                    i++;
                }
                right++;
                while (nums[left] % 2 != 1) {
                    left++;
                    j++;
                }
                left++;
                count--;
                res = res + i * j;
            }
        }
        return res;
    }
}