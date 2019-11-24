package Offer.a40数组中只出现一次的数字;

//num1,num2分别为长度为1的数组。传出参数
//将num1[0],num2[0]设置为返回结果
public class Solution {
    public void FindNumsAppearOnce(int[] array, int num1[], int num2[]) {
        int res = 0;
        for (int i : array) {
            res ^= i;
        }
        res &= -res;
        num1[0] = 0;
        num2[0] = 0;
        for (int i : array) {
            if ((i & res) == 0){
                num1[0]^=i;
            }else {
                num2[0]^=i;
            }
        }
    }

}