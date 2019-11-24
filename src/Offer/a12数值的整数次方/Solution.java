package Offer.a12数值的整数次方;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 */
public class Solution {
    /**
     * base^exponent
     */
    public double Power(double base, int exponent) {
        if (base == 0 && exponent < 0) {
            throw new RuntimeException();
        }
        if (base == 0) {
            return 0;
        }
        if (exponent == 0) {
            return 1;
        }
        int n = exponent;
        if (n < 0) {
            n = -n;
        }
        double res = Power(base, n >> 1);
        res = res * res;
        if ((n & 1) == 1) {
            res = res * base;
        }
        if (exponent<0){
            res = 1/res;
        }
        return res;
    }

}