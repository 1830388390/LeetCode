package A61v70.A064MinimumPathSum;

class Solution {
    public int minPathSum(int[][] grid) {
        int height = grid.length;
        int wide = grid[0].length;
        if (height == 0 || wide == 0) {
            return 0;
        }
        int y = height - 1;
        int x = wide - 2;
        for (int i = 1; i <= wide * height; i++) {
            if (y == height - 1) {
                grid[y][x] = grid[y][x] + grid[y][x + 1];
                x--;
                if (x < 0) {
                    x = wide - 1;
                    y--;
                }

            } else if (x == wide - 1) {
                grid[y][x] = grid[y][x] + grid[y + 1][x];
                x--;
                if (x < 0) {
                    x = wide - 1;
                    y--;
                }

            } else {
                grid[y][x] = grid[y][x] + Math.min(grid[y+1][x],grid[y][x+1]);
                x--;
                if (x < 0) {
                    x = wide - 1;
                    y--;
                }

            }
        }
        return grid[0][0];
    }
}