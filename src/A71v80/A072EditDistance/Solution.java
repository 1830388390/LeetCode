package A71v80.A072EditDistance;

class Solution {
    public int minDistance(String word1, String word2) {
        int lengtha = word1.length();
        int lengthb = word2.length();
        if (lengtha == 0 || lengthb == 0) {
            return lengtha == 0 ? lengthb : lengtha;
        }
        int[][] res = new int[lengtha + 1][lengthb + 1];
        for (int i = 0; i <= lengtha; i++) {
            res[i][0] = i;
        }
        for (int i = 0; i <= lengthb; i++) {
            res[0][i] = i;
        }
        int y = 1;
        int x = 1;
        while (y <= lengtha) {
            res[y][x] = Math.min(
                    Math.min(res[y-1][x] + 1, res[y][x-1] + 1)
                    , res[y-1][x-1]+ (word1.charAt(y-1) == word2.charAt(x-1) ? 0 : 1));
            x++;
            if (x == lengthb+1){
                x = 1;
                y++;
            }
        }
        return res[lengtha][lengthb];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().minDistance(new String("zoologicoarchaeologist"),new String("zoogeologist")));
    }
}