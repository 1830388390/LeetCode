package A31v40.A035SearchInsertPosition;


class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = nums.length;
        if (nums.length == 0){
            return -1;
        }
        return search(nums,target,0,l - 1);
    }

    public int search(int[] nums,int target , int start,int end){
        if (start == end){
            if (target > nums[start]){
                return start+1;
            }else {
                return start ;
            }
        }
        int mid = (start + end)/2;
        if (nums[mid]> target){
            return search(nums, target, start, mid);
        }else if (nums[mid] < target){
            return search(nums, target, mid + 1, end);
        }else {
            return mid == 0 ? 0 : mid - 1;
        }
    }

    public static void main(String[] args) {
        new Solution().searchInsert(new int[]{1,3,5,6},2);
    }
}