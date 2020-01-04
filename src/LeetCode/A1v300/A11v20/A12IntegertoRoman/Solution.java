package LeetCode.A1v300.A11v20.A12IntegertoRoman;

class Solution {
    public String romanToInt(int num) {
        int[] nums = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] rom = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        String res = "";
        for (int i=0;i<nums.length;i++){
            while (num >= nums[i]){
                num = num -nums[i];
                res = res+rom[i];
            }
        }
        return res;
    }
}