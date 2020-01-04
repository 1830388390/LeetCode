package Offer.a66机器人的运动范围;

public class Solution {
    int n = 0;
    int height;
    int wide;

    public int movingCount(int threshold, int rows, int cols) {
        this.height = rows;
        this.wide = cols;
        boolean[][] isUsed = new boolean[rows][cols];
        pass(threshold, 0, 0, isUsed);
        return n;
    }

    private void pass(int k, int y, int x, boolean[][] isUsed) {
        if (y < 0 || y >= height || x < 0 || x >= wide || isUsed[y][x] || xySum(x, y) > k) {
            return;
        }
        isUsed[y][x] = true;
        n++;
        pass(k, y + 1, x, isUsed);
        pass(k, y, x + 1, isUsed);
        pass(k, y - 1, x, isUsed);
        pass(k, y, x - 1, isUsed);
    }

    private static int xySum(int x, int y) {
        int sum = 0;
        while (x != 0) {
            sum += x % 10;
            x /= 10;
        }

        while (y != 0) {
            sum += y % 10;
            y /= 10;
        }
        return sum;
    }

}