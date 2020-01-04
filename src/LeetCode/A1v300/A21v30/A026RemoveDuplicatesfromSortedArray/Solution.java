package LeetCode.A1v300.A21v30.A026RemoveDuplicatesfromSortedArray;

class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 1;
        int j = 1;
        if (nums.length == 0 ){
            return 0;
        }
        if (nums.length == 1){
            return 1;
        }
        while (j<nums.length){
            if (nums[i - 1] == nums[j]){
                j++;
            }else {
                nums[i] = nums[j];
                i++;
                j++;
            }
        }
        return i;
    }
}