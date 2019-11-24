package A1v300.A61v70.A063UniquePathsII;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if (obstacleGrid[0].length == 0 || obstacleGrid.length == 0) {
            return 0;
        }
        if (obstacleGrid.length == 1){
            for (int i = 0;i<=obstacleGrid[0].length -1;i++){
                if (obstacleGrid[0][i] == 1){
                    return 0;
                }
            }
            return 1;
        }
        if (obstacleGrid[0].length == 1){
            for (int i = 0;i<=obstacleGrid.length -1;i++){
                if (obstacleGrid[i][0] == 1){
                    return 0;
                }
            }
            return 1;
        }
        int height = obstacleGrid.length;
        int width = obstacleGrid[0].length;

        if (obstacleGrid[0][0] == 1){
            return 0;
        }else {
            obstacleGrid[0][0] = -1;
        }
        for (int i = 1;i<=width - 1;i++){
            if (obstacleGrid[0][i] != 1 && obstacleGrid[0][i-1] == -1){
                obstacleGrid[0][i] = -1;
            }else {
                obstacleGrid[0][i] = 1;
            }
        }
        for (int i = 1;i<=height - 1;i++){
            if (obstacleGrid[i][0] != 1 && obstacleGrid[i-1][0] == -1){
                obstacleGrid[i][0] = -1;
            }else {
                obstacleGrid[i][0] = 1;
            }
        }

        int x = 1;
        int y = 1;
        while (x<=width - 1){
            if (obstacleGrid[y][x] == 1 || obstacleGrid[y][x-1] == 1 && obstacleGrid[y-1][x] ==1){
                obstacleGrid[y][x] = 1;
                y++;
                if (y == height){
                    y = 1;
                    x++;
                }
                continue;
            }else {
                obstacleGrid[y][x] = (obstacleGrid[y][x-1] == 1 ? 0 : obstacleGrid[y][x-1])
                                        + (obstacleGrid[y - 1][x] == 1 ? 0 : obstacleGrid[y - 1][x]);
                y++;
                if (y == height){
                    y = 1;
                    x++;
                }
                continue;
            }

        }
        return obstacleGrid[height - 1][width - 1] == 1 ? 0 : -obstacleGrid[height - 1][width - 1];
    }

    public static void main(String[] args) {
        new Solution().uniquePathsWithObstacles(new int[][]{{0,0},{1,1},{0,0}});
    }
}