package Offer.a48不用加减乘除做加法;

public class Solution {
    public int Add(int num1, int num2) {
        int sum = 0;
        while (num2 != 0) {
            sum = num1 ^ num2;
            int carry = (num1 & num2) << 1;
            num2 = carry;
            num1 = sum;
        }
        return num1;
    }
}