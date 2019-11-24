package Offer.a1二维数组中的查找;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），
 * 每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution {
    public boolean Find(int target, int [][] array) {
        int height = array.length;
        if (height == 0 || array[0].length == 0){
            return false;
        }
        int wide = array[0].length;
        int y = height - 1;
        int x = 0;
        while (y < height && x < wide && y >=0){
            int tmp = array[y][x];
            if (tmp == target){
                return true;
            }
            if (tmp < target){
                x ++;
            }else {
                y--;
            }
        }
        return false;
    }
}