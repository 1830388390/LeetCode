package LeetCode.A1v300.A31v40.A031NextPermutation;

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        boolean ischanged = false;
        int l = nums.length;
        for (int lastindex = l - 1; lastindex > 0; lastindex--) {
            if (nums[lastindex] > nums[lastindex - 1]) {
                int target = nums[lastindex - 1];
                int i = lastindex;
                while (++i <= l - 1) {
                    if (target<nums[i]){
                    }else {
                        break;
                    }
                }
                nums[lastindex - 1] = nums[i - 1];
                nums[i - 1] = target;
                int start = lastindex;
                int end = l - 1;
                while (start < end) {
                    int temp = nums[start];
                    nums[start] = nums[end];
                    nums[end] = temp;
                    start++;
                    end--;
                }

                ischanged = true;
                return;
            }
        }
        if (!ischanged) {
            int start = 0;
            int end = l - 1;
            while (start < end) {
                int temp = nums[start];
                nums[start] = nums[end];
                nums[end] = temp;
                start++;
                end--;
            }
        }
    }
}