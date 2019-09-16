package A171v180.A174DungeonGame;

class Solution {
    public int calculateMinimumHP(int[][] dungeon) {
        int height = dungeon.length;
        int wide = dungeon[0].length;
        if (height == 0 || wide == 0) {
            return 0;
        }
        dungeon[height - 1][wide - 1] = dungeon[height - 1][wide - 1] > 0 ?
                                         0 : -dungeon[height - 1][wide - 1];
        for (int i = height - 2;i>=0;i --){
            int needLifeValue = dungeon[i + 1][wide - 1] - dungeon[i][wide - 1];
            dungeon[i][wide - 1] = Integer.max(0,needLifeValue);
        }
        for (int i = wide - 2;i>=0;i --){
            int needLifeValue = dungeon[height - 1][i + 1] - dungeon[height - 1][i];
            dungeon[height - 1][i] = Integer.max(0,needLifeValue);
        }
        int y = height - 2;
        int x = wide - 2;
        while (y >=0 && x >=0){
            int needLifeValue = Integer.min(dungeon[y + 1][x],dungeon[y][x + 1]) - dungeon[y][x];
            dungeon[y][x] = Integer.max(0,needLifeValue);
            x--;
            if (x<0){
                y--;
                x = wide - 2;
            }
        }
        return dungeon[0][0] + 1;
    }
}