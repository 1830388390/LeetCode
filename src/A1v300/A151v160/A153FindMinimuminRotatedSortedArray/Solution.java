package A1v300.A151v160.A153FindMinimuminRotatedSortedArray;

class Solution {
    public int findMin(int[] nums) {
        int l = nums.length;
        if (nums[0] < nums[l - 1]) {
            return nums[0];
        }
        return findReverse(nums,0,l - 1);
    }

    private int findReverse(int[] nums, int l, int r) {
        if (l == r) {
            return nums[l];
        }
        int mid = (l + r) / 2;
        if (nums[mid] > nums[r]){
            return findReverse(nums, mid + 1, r);
        }else if (nums[mid] < nums[r]){
            return findReverse(nums, l, mid);
        }else {
            return findReverse(nums, l, r - 1);
        }
    }
}