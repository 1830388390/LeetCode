package LeetCode.A301v500.A324WiggleSortII;

class Solution {
    public void wiggleSort(int[] nums) {
        int length = nums.length;
        if (length <= 1) {
            return;
        }
        int slow = 0;
        int fast = 1;
        boolean state = false;
        while (fast < length) {
            if (nums[fast] > nums[slow] && !state) {
                state = true;
                fast++;
                slow++;
                continue;
            }
            if (nums[fast] < nums[slow] && state) {
                state = false;
                fast++;
                slow++;
                continue;
            }
            if (!state) {
                int tmp = fast;
                while (tmp + 1 < length && nums[tmp] <= nums[slow]) {
                    tmp++;
                }
                int f = nums[fast];
                nums[fast] = nums[tmp];
                nums[tmp] = f;
                slow++;
                fast++;
                state = true;
                continue;
            }
            if (state) {
                int tmp = fast;
                while (tmp + 1 < length && nums[tmp] >= nums[slow]) {
                    tmp++;
                }
                int f = nums[fast];
                nums[fast] = nums[tmp];
                nums[tmp] = f;
                slow++;
                fast++;
                state = false;
                continue;
            }
        }
    }
}