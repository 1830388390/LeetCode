package weekCompetition;

import java.util.*;

class Solution {
    public int maxNumberOfApples(int[] arr) {
        Arrays.sort(arr);
        int max = 5000;
        int i = -1;
        while (max > 0) {
            i++;
            if (i == arr.length) {
                break;
            }
            max = max - arr[i];
        }
        return i;
    }

    static class Solution2 {
        public int minKnightMoves(int x, int y) {
            x = Math.abs(x);
            y = Math.abs(y);
            boolean[][] isUsed = new boolean[y + 3][x + 3];
            int[] n = new int[]{0,0,0};
            Queue<int[]> nodeQueue = new LinkedList<>();
            nodeQueue.add(n);
            while (true) {
                int[] tmp = nodeQueue.poll();
                int tx = tmp[0];
                int ty = tmp[1];
                int tp = tmp[2];
                if (tx == x && ty == y) {
                    return tp;
                }
                if (tx < 0 || ty < 0 || tx > x + 2 || ty > y + 2 || isUsed[ty][tx]) {
                    continue;
                } else {
                    isUsed[ty][tx] = true;
                    nodeQueue.add(new int[]{tx + 1, ty + 2, tp + 1});
                    nodeQueue.add(new int[]{tx + 1, ty - 2, tp + 1});
                    nodeQueue.add(new int[]{tx - 1, ty + 2, tp + 1});
                    nodeQueue.add(new int[]{tx - 1, ty - 2, tp + 1});
                    nodeQueue.add(new int[]{tx + 2, ty + 1, tp + 1});
                    nodeQueue.add(new int[]{tx + 2, ty - 1, tp + 1});
                    nodeQueue.add(new int[]{tx - 2, ty + 1, tp + 1});
                    nodeQueue.add(new int[]{tx - 2, ty - 1, tp + 1});
                }
            }
        }
    }

    class Solution3 {
        public int minKnightMoves(int x,
                                  int y) {
            x = Math.abs(x);// 调整到第一象限
            y = Math.abs(y);

            if (x + y == 0) {// 起点(0,0)
                return 0;
            }
            if (x == 1 && y == 1) {// 此算法是无法计算点(1,1)
                return 2;
            }

            int m = x + 3;
            int n = y + 3;
            int[][] board = new int[m][n];

            int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
            int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0});

            while (!queue.isEmpty()) {
                int[] cur = queue.poll();// 出队列
                for (int i = 0; i < 8; ++i) {
                    int r = cur[0] + dx[i];
                    int c = cur[1] + dy[i];
                    if (r < 0 || r >= m || c < 0 || c >= n) {// 越界
                        continue;
                    }
                    if (r + c == 0) {// 回到了起点
                        continue;
                    }
                    if (board[r][c] == 0) {// 未访问过当前点
                        board[r][c] = board[cur[0]][cur[1]] + 1;
                        if (r == x && c == y) {// 当前点就是目标点
                            return board[r][c];// 返回结果
                        }
                        queue.add(new int[]{r, c});// 不是目标点，入队列
                    }
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution2().minKnightMoves(21,27));
    }
}