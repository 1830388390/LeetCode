package LeetCode.weekCompetition;

import java.util.HashMap;
import java.util.Map;

public class C157 {

    class Solution {
        public int minCostToMoveChips(int[] chips) {
            int[] res = new int[2];
            for (int tmp : chips) {
                res[tmp % 2]++;
            }
            return Math.min(res[0], res[1]);
        }
    }

    class Solution2 {
        public int longestSubsequence(int[] arr, int difference) {
            Map<Integer, Integer> sequences = new HashMap<>();
            int res = 1;
            for (int tmp : arr) {
                if (sequences.containsKey(tmp - difference)) {
                    sequences.put(tmp, sequences.get(tmp - difference) + 1);
                    res = Integer.max(sequences.get(tmp), res);
                } else {
                    sequences.put(tmp, 1);
                }
            }
            return res;
        }
    }

    static class Solution3 {
        int height;
        int wide;
        int res = 0;
        int[][] grid;

        public int getMaximumGold(int[][] grid) {
            this.grid = grid;
            height = grid.length;
            wide = grid[0].length;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < wide; j++) {
                    if (grid[i][j] != 0 && TP(i, j) >= 3) {
                        boolean[][] b = new boolean[height][wide];
                        DFS(i, j, 0, b);
                    }
                }
            }
            return res;
        }

        private void DFS(int y, int x, int sum, boolean[][] isUsed) {
            /**
             * 特判,"撞墙"直接返回结果
             */
            if (y >= height || x >= wide || y < 0 || x < 0 || isUsed[y][x] || grid[y][x] == 0) {
                res = Integer.max(res, sum);
                return;
            }
            isUsed[y][x] = true;
            DFS(y + 1, x, sum + grid[y][x], isUsed);
            DFS(y, x + 1, sum + grid[y][x], isUsed);
            DFS(y - 1, x, sum + grid[y][x], isUsed);
            DFS(y, x - 1, sum + grid[y][x], isUsed);
            isUsed[y][x] = false;
        }

        /**
         * 特判,由于起点必定在路径的两端 而不是在路径里面,
         * 所以只要一个点四个路径有两个数字大于0,他就是这个路径里面的点.
         * 四个角需要特殊处理,因为[[23,21],[23,3]] 按以上方法处理后结果为0
         */
        private int TP(int y, int x) {
            if (y == 0 && x == 0 ||
                    y == 0 && x == wide - 1 ||
                    y == height - 1 && x == 0 ||
                    y == height - 1 && x == wide - 1) {
                return 3;
            }
            int r = 0;
            if (y - 1 < 0 || grid[y - 1][x] == 0) {
                r++;
            }
            if (y + 1 >= height || grid[y + 1][x] == 0) {
                r++;
            }
            if (x - 1 < 0 || grid[y][x - 1] == 0) {
                r++;
            }
            if (x + 1 >= wide || grid[y][x + 1] == 0) {
                r++;
            }
            return r;
        }
    }

    class Solution4 {
        /**
         * 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'）
         * 每个元音 'a' 后面都只能跟着 'e'
         * 每个元音 'e' 后面只能跟着 'a' 或者是 'i'
         * 每个元音 'i' 后面 不能 再跟着另一个 'i'
         * 每个元音 'o' 后面只能跟着 'i' 或者是 'u'
         * 每个元音 'u' 后面只能跟着 'a'
         */
        public int countVowelPermutation(int n) {
            double a = 1, e = 1, i = 1, o = 1, u = 1;
            double res = 0;
            double mod = 1e9 + 7;
            for (int j = 1; j < n; j++) {
                double a1, e1, i1, o1, u1;
                a1 = (e + i + u) % mod;
                e1 = (a + i) % mod;
                i1 = (e + o) % mod;

                u1 = (i + o) % mod;
                o1 = i;
                a = a1;
                e = e1;
                i = i1;
                o = o1;
                u = u1;
            }
            res = (a + e + i + o + u) % mod;
            return (int) res;
        }

    }

    public static void main(String[] args) {
        //[[23,21,38,12,18,36,0,7,30,29,20,3,28],[23,3,19,2,1,11,4,8,9,24,6,5,35]]
        new Solution3().getMaximumGold(new int[][]{{23, 21, 38, 12, 18, 36, 0, 7, 30, 29, 20, 3, 28}, {23, 3, 19, 2, 1, 11, 4, 8, 9, 24, 6, 5, 35}});
    }
}
