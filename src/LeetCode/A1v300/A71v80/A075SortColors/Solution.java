package LeetCode.A1v300.A71v80.A075SortColors;

class Solution {
    public void sortColors(int[] nums) {
        int l = nums.length;
        if (l == 0){
            return;
        }
        int zero = 0;
        int one = 0;
        int two = 0;
        for (int i = 0;i <=l-1;i++){
            if (nums[i] == 0){
                zero++;
                continue;
            }
            if (nums[i] == 1){
                one++;
                continue;
            }
            if (nums[i] == 2){
                two++;
                continue;
            }
        }
        for (int i = 0;i<=zero-1;i++){
            nums[i] = 0;
        }
        for (int i = zero;i<=zero + one-1;i++){
            nums[i] = 1;
        }
        for (int i = zero + one;i<=zero + one + two-1;i++){
            nums[i] = 2;
        }
    }
}