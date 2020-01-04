package LeetCode.A1v300.A31v40.A034FindFirstandLastPositionofElementinSortedArray;

class Solution {
    int i = -1;
    int j = -1;
    public int[] searchRange(int[] nums, int target) {
        search(nums,target,0,nums.length - 1);
        return new int[]{i,j};
    }

    public void search(int[] nums,int target,int start,int end){
        if (start > end){
            return;
        }
        if (start == end){
            if (nums[start] == target){
                i = i == -1 ? start : Math.min(i,start);
                j = Math.max(j,start);
            }else {
                return;
            }
        }
        int mid = (start + end)/2;
        if (nums[mid] == target){
            i = i == -1 ? mid : Math.min(i,mid);
            j = Math.max(j,mid);
            search(nums, target, mid + 1, end);
            search(nums, target, start, mid);
        }else if (nums[mid]<target){
            search(nums, target, mid + 1, end);
        }else if (nums[mid] > target){
            search(nums, target, start, mid);
        }
    }
    public static void main(String[] args) {
        new Solution().searchRange(new int[]{5,7,7,8,8,10},8);
    }
}