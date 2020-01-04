package LeetCode.weekCompetition;

import java.util.*;

public class C158 {

    class Solution {
        public int balancedStringSplit(String s) {
            int l = 0;
            int r = 0;
            int res = 0;
            for (char c : s.toCharArray()) {
                if (c == 'L') {
                    l++;
                } else {
                    r++;
                }
                if (l == r) {
                    res++;
                    l = 0;
                    r = 0;
                }
            }
            return res;
        }
    }

    class Solution2 {
        public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
            int[][] checkerboard = new int[63][63];
            for (int[] tmp : queens){
                checkerboard[tmp[0]][tmp[1]] = 1;
            }
            int y = king[0];
            int x = king[1];
            List<List<Integer>> res = new ArrayList<>();
            //上
            for (int i = y - 1; i >= 0; i--) {
                if (checkerboard[i][x] == 1) {
                    res.add(Arrays.asList(i,x));
                    break;
                }
            }
            //下
            for (int i = y + 1; i < 63; i++) {
                if (checkerboard[i][x] == 1) {
                    res.add(Arrays.asList(i,x));
                    break;
                }
            }
            //左
            for (int i = x - 1;i>=0;i--){
                if (checkerboard[y][i] == 1){
                    res.add(Arrays.asList(y,i));
                    break;
                }
            }
            //右
            for (int i = x + 1;i<63;i++){
                if (checkerboard[y][i] == 1){
                    res.add(Arrays.asList(y,i));
                    break;
                }
            }
            //左上
            for (int i = x - 1,j = y - 1;i>=0&&j>=0;i--,j--){
                if (checkerboard[j][i] == 1){
                    res.add(Arrays.asList(j,i));
                    break;
                }
            }
            //右下
            for (int i = x + 1,j = y + 1;i<63&&j<63;i++,j++){
                if (checkerboard[j][i] == 1){
                    res.add(Arrays.asList(j,i));
                    break;
                }
            }
            //左下
            for (int i = x - 1,j = y + 1;i>=0&&j<63;i--,j++){
                if (checkerboard[j][i] == 1){
                    res.add(Arrays.asList(j,i));
                    break;
                }
            }
            //右上
            for (int i = x + 1,j = y - 1;i<63&&j>=0;i++,j--){
                if (checkerboard[j][i] == 1){
                    res.add(Arrays.asList(j,i));
                    break;
                }
            }
            return res;
        }
    }

    class Solution3 {
        public int dieSimulator(int n, int[] rollMax) {
            return 1;
        }
    }

    class Solution4 {
        public int maxEqualFreq(int[] nums) {
            return 1;
        }
    }
}
