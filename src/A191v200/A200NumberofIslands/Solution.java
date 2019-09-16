package A191v200.A200NumberofIslands;

class Solution {
    public int numIslands(char[][] grid) {
        int height = grid.length;
        if (height == 0){
            return 0;
        }
        int wide = grid[0].length;
        int x = 0;
        int y = 0;
        int res = 0;
        int[][] direction = new int[][]{
                {1,0},{0,1},{-1,0},{0,-1}
        };
        while (y < grid.length) {
            if (grid[y][x] == '1') {
                res++;
                makeWater(grid, y, x, height, wide);
            }
            x++;
            if (x == wide) {
                x = 0;
                y++;
            }
        }
        return res;
    }


    public void makeWater(char[][] grid, int y, int x, int height, int wide) {
        if (y < 0 || y >= height || x < 0 || x >= wide || grid[y][x] == '0') {
            return;
        }
        if (grid[y][x] == '1') {
            grid[y][x] = '0';
        }
        makeWater(grid, y + 1, x, height, wide);
        makeWater(grid, y, x + 1, height, wide);
        makeWater(grid, y - 1, x, height, wide);
        makeWater(grid, y, x - 1, height, wide);
    }
}