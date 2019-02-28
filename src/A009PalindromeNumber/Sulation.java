package A009PalindromeNumber;

import java.util.Stack;

/*
判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。

示例 1:

输入: 121
输出: true
示例 2:

输入: -121
输出: false
解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
示例 3:

输入: 10
输出: false
解释: 从右向左读, 为 01 。因此它不是一个回文数。
 */
class Solution {
    public boolean isPalindrome(int x) {

        Stack<Integer> s1 = new Stack<>();

        Stack<Integer> s2 = new Stack<>();

        Stack<Integer> s3 = new Stack<>();

        int y = x;

        if (x < 0){
            return false;
        }
        if (x == 0){
            return true;
        }
        while (true){

            if (y <= 0){
                break;
            }else  {

                int z = y%10;

                s1.push(z);
                s2.push(z);
                y = y/10;
            }

        }

        int sizes = s1.size();

        for (int i = 0;i < sizes; i++){
            int aa = s1.pop();
            s3.push(aa);
        }


        for (int i = 0;i <= s2.size() ; i++){
            int a= s2.pop();
            int b= s3.pop();
            if (a != b){
                return false;
            }
        }

        return true;
    }
}