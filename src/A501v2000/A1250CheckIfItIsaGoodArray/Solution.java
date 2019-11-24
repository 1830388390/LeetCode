package A501v2000.A1250CheckIfItIsaGoodArray;

class Solution {
    public boolean isGoodArray(int[] nums) {
        int res = nums[0];
        for (int i = 1;i<nums.length;i++){
            res = gcd(res,nums[i]);
        }
        return res == 1;
    }

    public int gcd(int a,int b){
        int c = a%b;
        while (c>0){
            a = b;
            b = c;
            c = a%b;
        }
        return b;
    }
}