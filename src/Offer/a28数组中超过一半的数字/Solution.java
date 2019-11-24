package Offer.a28数组中超过一半的数字;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class Solution {
    public int MoreThanHalfNum_Solution(int[] array) {
        int num = array[0];
        int times = 1;
        for (int j = 1;j<array.length ;j++) {
            int i = array[j];
            if (i != num) {
                if (times - 1 < 0) {
                    num = i;
                    times = 0;
                } else {
                    times--;
                }
            } else {
                times++;
            }
        }
        return times >= 1 ? num : 0;
    }

}