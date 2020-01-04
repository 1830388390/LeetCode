package LeetCode.A1v300.A71v80.A080RemoveDuplicatesfromSortedArrayII;

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for (int n : nums) {
            if (i < 2 || n > nums[i-2]) {
                nums[i++] = n;
            }
        }
        return i;
    }
}