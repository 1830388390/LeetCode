package LeetCode.A1v300.A161v170.A162FindPeakElement;

class Solution {
    public int findPeakElement(int[] nums) {
        int l = nums.length;
        if (l <= 1){
            return l == 1 ? nums[0] : 0;
        }
        return binarySearch(nums,0,l - 1);
    }

    private int binarySearch(int[] nums,int l,int r){
        if (l == r){
            return l;
        }
        int mid = (l + r)/2;
        if (nums[mid + 1] > nums[mid]){
            return binarySearch(nums, mid + 1, r);
        }else {
            return binarySearch(nums, l, mid);
        }
    }
}

class Solution2 {
    public int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length - 1);
    }
    public int search(int[] nums, int l, int r) {
        if (l == r)
            return l;
        int mid = (l + r) / 2;
        if (nums[mid] > nums[mid + 1])
            return search(nums, l, mid);
        return search(nums, mid + 1, r);
    }
}
