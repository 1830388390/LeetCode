package A31v40.A035SearchInsertPosition;


class Solution {
    public int searchInsert(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length-1;
        int mid = (start + end) / 2;

        while (start <= end) {

            if (nums[mid] > target) {

                end = mid - 1;
                mid = (start + end) / 2;
            } else if (nums[mid] < target) {

                start = mid + 1;
                mid = (start + end) / 2;
            } else {
                return mid;
            }

        }

        start = mid - 1 >= 0 ? mid - 1 : 0;
        end = mid +1  <= nums.length - 1 ? mid + 1 : nums.length - 1;

        if (nums[0] > target) {
            return 0;
        }

        if (target > nums[nums.length - 1]) {
            return nums.length;
        }

        for (int i = start; i <= end; i++) {

            if (i - 1 < 0) {
                continue;
            } else if (nums[i - 1] < target && target < nums[i]) {
                return i;
            }
        }

        return -1;
    }
}