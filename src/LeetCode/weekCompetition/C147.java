package LeetCode.weekCompetition;

import java.util.HashMap;
import java.util.Map;

public class C147 {

    class Solution {
        public int tribonacci(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1 || n == 2) {
                return 1;
            }
            int[] nums = new int[n + 1];
            nums[0] = 0;
            nums[1] = 1;
            nums[2] = 1;
            for (int i = 3; i <= n; i++) {
                nums[i] = nums[i - 1] + nums[i - 2] + nums[i - 3];
            }
            return nums[n];
        }
    }

    class Solution2 {
        //        board = ["abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"]
        String[] board = new String[]{"abcde", "fghij", "klmno", "pqrst", "uvwxy", "z"};

        public String alphabetBoardPath(String target) {
            Map<Character, int[]> words = new HashMap<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length(); j++) {
                    words.put(board[i].charAt(j), new int[]{i, j});
                }
            }
            StringBuffer res = new StringBuffer();
            int y = 0;
            int x = 0;
            for (int i = 0; i < target.length(); i++) {
                int newX = words.get(target.charAt(i))[1];
                int newY = words.get(target.charAt(i))[0];

                if (x == 0 && y == 5) {
                    if (newY - y > 0) {
                        for (int j = 0; j < newY - y; j++) {
                            res.append("D");
                        }
                    }
                    if (newY - y < 0) {
                        for (int j = 0; j < y - newY; j++) {
                            res.append("U");
                        }
                    }
                    if (newX - x > 0) {
                        for (int j = 0; j < newX - x; j++) {
                            res.append("R");
                        }
                    }
                    if (newX - x < 0) {
                        for (int j = 0; j < x - newX; j++) {
                            res.append("L");
                        }
                    }
                } else {
                    if (newX - x > 0) {
                        for (int j = 0; j < newX - x; j++) {
                            res.append("R");
                        }
                    }
                    if (newX - x < 0) {
                        for (int j = 0; j < x - newX; j++) {
                            res.append("L");
                        }
                    }
                    if (newY - y > 0) {
                        for (int j = 0; j < newY - y; j++) {
                            res.append("D");
                        }
                    }
                    if (newY - y < 0) {
                        for (int j = 0; j < y - newY; j++) {
                            res.append("U");
                        }
                    }
                }

                res.append("!");
                x = newX;
                y = newY;
            }
            return res.toString();
        }
    }

    class Solution3 {
        public int largest1BorderedSquare(int[][] grid) {
            int height = grid.length;
            int width = grid[0].length;
            int[][] colSum = new int[height + 1][width + 1];
            int[][] rowSum = new int[height + 1][width + 1];
            for (int i = 1; i <= height; i++) {
                for (int j = 1; j <= width; j++) {
                    if (grid[i - 1][j - 1] == 0) {
                        rowSum[i][j] = 0;
                    } else {
                        rowSum[i][j] = rowSum[i][j - 1] + 1;
                    }
                }
            }
            for (int i = 1; i <= width; i++) {
                for (int j = 1; j <= height; j++) {
                    if (grid[j - 1][i - 1] == 0) {
                        colSum[j][i] = 0;
                    } else {
                        colSum[j][i] = colSum[j - 1][i] + 1;
                    }
                }
            }
            int area = 0;
            for (int x1 = 0; x1 < width; x1++) {
                for (int y1 = 0; y1 < height; y1++) {
                    if (grid[y1][x1] == 0) {
                        continue;
                    }
                    for (int x2 = x1,y2 = y1; x2 < width && y2 < height; x2++,y2++) {
                            if (grid[y2][x2] == 0) {
                                continue;
                            }
                            if (isRectangle(y1 + 1, x1 + 1, y2 + 1, x2 + 1, colSum, rowSum)) {
                                if (y1 == y2 || x1 == x2) {
                                    area = Integer.max(1, area);
                                } else {
                                    if ((y2 - y1) == (x2 - x1 )){
                                        area = Integer.max((y2 - y1 + 1) * (x2 - x1 + 1), area);
                                    }

                                }

                            }

                    }

                }
            }
            return area;
        }

        private boolean isRectangle(int y1, int x1, int y2, int x2, int[][] colSum, int[][] rowSum) {
            return y2 - y1 == colSum[y2][x1] - colSum[y1][x1] &&
                    y2 - y1 == colSum[y2][x2] - colSum[y1][x2] &&
                    x2 - x1 == rowSum[y1][x2] - rowSum[y1][x1] &&
                    x2 - x1 == rowSum[y2][x2] - rowSum[y2][x1] ;
        }
    }

    class Solution4 {
        int[] alls;
        int[][] dp;
        public int stoneGameII(int[] piles) {
            alls = new int[piles.length + 1];
            int all = 0;
            for (int i = 0; i < piles.length; i++) {
                all += piles[i];
                alls[i + 1] = all;
            }
            dp = new int[piles.length+2][piles.length + 1];
            return max(0, piles.length - 1, 1);
        }

        private int max(int sta, int end, int M) {
            if (dp[sta][M] > 0) {
                return dp[sta][M];
            }
            int ans = 0;
            for (int i = 1; i <= 2 * M && (sta + i - 1) <= end; i++) {
                ans = Math.max(ans, alls[end + 1] - alls[sta] - max(sta + i, end, Math.max(M, i)));
            }
            dp[sta][M] = ans;
            return ans;
        }
    }

}
