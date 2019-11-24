package Offer.a51构建乘积数组;

import java.util.ArrayList;

/**
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。不能使用除法。
 */
public class Solution {
    public int[] multiply(int[] A) {
        if (A.length <= 1) {
            return new int[]{0};
        }
        int sum = 1;
        int[] B = new int[A.length];
        B[0] = 1;
        for (int i = 1; i < A.length; i++) {
            sum = sum * A[i - 1];
            B[i] = sum;
        }
        sum = 1;
        for (int i = A.length - 2; i >=0; i--) {
            sum =  sum * A[i + 1];
            B[i] *= sum;
        }
        return B;
    }
}