package Offer.a19顺时针打印矩阵;


/**
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，
 * 例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16
 * 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 */

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<>();
        int height = matrix.length;
        if (height == 0 || matrix[0].length == 0) {
            return res;
        }
        int wide = matrix[0].length;
        int y = 0, x = 0;
        int[][] d = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int f = 0;
        boolean[][] isUsed = new boolean[height][wide];
        while (res.size() != height * wide) {
            res.add(matrix[y][x]);
            isUsed[y][x] = true;
            int ty = y + d[f][0];
            int tx = x + d[f][1];
            if (ty>=height || ty <0 || tx >=wide || tx <0 || isUsed[ty][tx] == true){
                f = (f+1)%4;
                y = y + d[f][0];
                x = x + d[f][1];
            }else {
                y = ty;
                x = tx;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().printMatrix(new int[][]{{1,2},{3,4}});
    }
}