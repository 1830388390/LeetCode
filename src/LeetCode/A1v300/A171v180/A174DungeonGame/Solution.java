package LeetCode.A1v300.A171v180.A174DungeonGame;

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int height = dungeon.length;
        int width = dungeon[0].length;
        if (height == 0 || width == 0) {
            return 0;
        }
        dungeon[height - 1][width - 1] = dungeon[height - 1][width - 1] > 0 ?
                                         0 : -dungeon[height - 1][width - 1];
        for (int i = height - 2;i>=0;i --){
            int needLifeValue = dungeon[i + 1][width - 1] - dungeon[i][width - 1];
            dungeon[i][width - 1] = Integer.max(0,needLifeValue);
        }
        for (int i = width - 2;i>=0;i --){
            int needLifeValue = dungeon[height - 1][i + 1] - dungeon[height - 1][i];
            dungeon[height - 1][i] = Integer.max(0,needLifeValue);
        }
        int y = height - 2;
        int x = width - 2;
        while (y >=0 && x >=0){
            int needLifeValue = Integer.min(dungeon[y + 1][x],dungeon[y][x + 1]) - dungeon[y][x];
            dungeon[y][x] = Integer.max(0,needLifeValue);
            x--;
            if (x<0){
                y--;
                x = width - 2;
            }
        }
        return dungeon[0][0] + 1;
    }
}