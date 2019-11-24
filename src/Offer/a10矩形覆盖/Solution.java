package Offer.a10矩形覆盖;

/**
 * 我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */

public class Solution {
    public int RectCover(int target) {
        if(target == 0){
            return 0;
        }
        if(target == 1){
            return 1;
        }
        if(target == 2){
            return 2;
        }
        int[] res = new int[target];
        res[0] = 1;
        res[1] = 2;
        for(int i = 2;i<target;i++){
            res[i] = res[i - 1] + res[i - 2];
        }
        return res[target - 1];
    }
}