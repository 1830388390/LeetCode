package Offer.a9变态跳台阶;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */

public class Solution {
    public int JumpFloorII(int target) {
        int[] res = new int[target];
        res[target - 1] = 1;
        for (int i = target - 2;i>=0;i--){
            res[i] = res[i+1]*2;
        }
        return res[0];
    }
}