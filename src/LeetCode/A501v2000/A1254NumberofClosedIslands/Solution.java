package LeetCode.A501v2000.A1254NumberofClosedIslands;

class Solution {
    int height;
    int wide;
    int flag;
    public int closedIsland(int[][] grid) {
        this.height = grid.length;
        this.wide = grid[0].length;
        if (height < 3 || wide < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < wide; j++) {

                if (grid[i][j] == 0) {
                    this.flag = 1;
                    isLand(i, j, grid);
                    res = res + flag;
                }
            }
        }
        return res;
    }

    private void isLand(int y, int x, int[][] grid) {
        if (y >= height || x >= wide || y < 0 || x < 0) {
            this.flag = 0;
            return;
        }
        if (grid[y][x] != 0) {
            return;
        }
        grid[y][x] = -1;
        isLand(y + 1, x, grid);
        isLand(y, x + 1, grid);
        isLand(y - 1, x, grid);
        isLand(y, x - 1, grid);
    }
}

