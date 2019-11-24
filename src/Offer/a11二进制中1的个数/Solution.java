package Offer.a11二进制中1的个数;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution {
    public int NumberOf1(int n) {
        int res = 0;
        for (int i = 0; i < 32; i++) {
            int m = n& 1<<i;
            if (m!=0) {
                res++;
            }
        }
        return res;
    }
}