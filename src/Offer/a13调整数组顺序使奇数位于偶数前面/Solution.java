package Offer.a13调整数组顺序使奇数位于偶数前面;

import java.util.LinkedList;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，
 * 使得所有的奇数位于数组的前半部分，所有的偶数位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution {
    public void reOrderArray(int[] array) {
        int length = array.length;
        if (length == 0 || length == 1) {
            return;
        }
        List<Integer> Odd = new LinkedList<>();
        List<Integer> Even = new LinkedList<>();
        for (int i : array){
            if ((i&1) == 0){
                Even.add(i);
            }else {
                Odd.add(i);
            }
        }
        int i = 0;
        for (int k : Odd){
            array[i++] = k;
        }
        for (int k : Even){
            array[i++] = k;
        }
    }
}