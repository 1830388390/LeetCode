package A281v290.A283MoveZeroes;

class Solution {
    public void moveZeroes(int[] nums) {
        int length = nums.length;
        if (length<=1){
            return;
        }
        int i = 0;
        while (i< length&&nums[i] !=0){
            i++;
        }
        int j = i+1;
        while (j<length && i<length){
            if (nums[j] !=0){
                nums[i] = nums[j];
                nums[j] = 0;
                while (i< length&&nums[i] !=0){
                    i++;
                }
            }else {
                j++;
            }
        }
    }
}