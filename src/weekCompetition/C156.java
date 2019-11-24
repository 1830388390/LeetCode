package weekCompetition;

import javafx.util.Pair;

import java.io.PipedReader;
import java.nio.channels.Pipe;
import java.util.*;

class C156 {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> times = new HashMap<>();
        for (int i : arr) {
            times.put(i, times.getOrDefault(i, 0) + 1);
        }
        Set<Integer> t = new HashSet<>();
        for (int i : times.values()) {
            if (t.contains(i)) {
                return false;
            } else {
                t.add(i);
            }
        }
        return true;
    }

    static class Solution2 {
        public int equalSubstring(String s, String t, int maxCost) {
            int length = s.length();
            int cost = 0;
            int l = -Integer.MAX_VALUE;
            int start = 0; //窗口左界限
            /*
            遍历窗口右界限i
             */
            for (int i = 0; i < length; i++) {
                int dif = Math.abs(s.charAt(i) - t.charAt(i));

                if (dif + cost <= maxCost) {
                    /*
                    总消费小于maxCost
                    */
                    cost += dif;
                    l = Integer.max(l, i - start);
                } else if (dif > maxCost) {
                    /*
                    相差大于maxCost,重置start和cost
                     */
                    if (start == length - 1) {
                        return l == -Integer.MAX_VALUE ? 0 : l + 1;
                    } else {
                        start = i + 1;
                        cost = 0;
                    }
                } else {
                    /*
                    窗口左界限向右缩小,直到cost小于maxCost
                     */
                    cost = cost + dif;
                    while (cost > maxCost) {
                        cost -= Math.abs(s.charAt(start) - t.charAt(start));
                        start++;
                    }
                }
            }
            return l == -Integer.MAX_VALUE ? 0 : l + 1;
        }
    }

    static class Solution3 {
        public String removeDuplicates(String s, int k) {
            Stack<Pair<Character, Integer>> words = new Stack<>();
            words.push(new Pair<>(s.charAt(0), 1));
            for (int i = 1; i < s.length(); i++) {
                if (words.isEmpty()) {
                    words.push(new Pair<>(s.charAt(i), 1));
                } else {
                    char key = words.peek().getKey();
                    int value = words.peek().getValue();
                    if (s.charAt(i) == key) {
                        words.push(new Pair<>(s.charAt(i), value + 1));
                        if (value + 1 == k) {
                            for (int j = 1; j <= k; j++) {
                                words.pop();
                            }
                        }
                    } else {
                        words.push(new Pair<>(s.charAt(i), 1));
                    }
                }
            }
            StringBuffer sb = new StringBuffer();
            for (Pair<Character, Integer> p : words) {
                sb.append(p.getKey());
            }
            return sb.toString();
        }
    }

    static class Solution4 {

        int times = Integer.MAX_VALUE;
        int width;

        public int minimumMoves(int[][] grid) {
            this.width = grid.length;
            int headx = 1;
            int heady = 0;
            int tailx = 0;
            int taily = 0;
            makeRes(headx, heady, tailx, taily, 0, grid, false, false);
            return times == Integer.MAX_VALUE ? -1 : times;
        }

        private void makeRes(int headx, int heady, int tailx, int taily, int time, int[][] tmp, boolean isTurnClockwise, boolean isTurnAntiClockwise) {
            if (headx == width - 1 &&
                    heady == width - 1 &&
                    tailx == width - 2 &&
                    taily == width - 1) {
                times = Integer.min(time, times);
                return;
            }
            if (time > times) {
                return;
            }

            if (headx >= width || headx < 0 || heady >= width || heady < 0 ||
                    tailx >= width || tailx < 0 || taily >= width || taily < 0) {
                return;
            }

            if (tmp[heady][headx] == 1 || tmp[taily][tailx] == 1) {
                return;
            }
            if (heady == taily && heady + 1 < width && tmp[heady + 1][headx] == 0 && !isTurnAntiClockwise) {
                makeRes(tailx, heady + 1, tailx, taily, time + 1, tmp, true, isTurnAntiClockwise);
            }

            if (tailx == headx && headx + 1 < width && tmp[heady][headx + 1] == 0 && !isTurnClockwise) {
                makeRes(headx + 1, taily, tailx, taily, time + 1, tmp, isTurnClockwise, true);
            }

            makeRes(headx + 1, heady, tailx + 1, taily, time + 1, tmp, false, false);
            makeRes(headx, heady + 1, tailx, taily + 1, time + 1, tmp, false, false);

        }
    }

    class Solution4_2 {
        public int minimumMoves(int[][] grid) {
            int n = grid.length;
            int[][][] dp = new int[n][n][2]; // 放上三种状态，尾巴的横纵坐标和垂直或水平,0表示水平,1表示垂直。
            int[] dx = {0, 1}, dy = {1, 0}; // 如果让蛇向右移动一格，那么蛇整个身体x轴不变，y轴+1，同理向下也一样。
            dp[0][0][0] = 1;
            // base case是1，为什么是一呢，因为java开辟数组时默认会把所有数组归为0，本来应该是0，但是为了方便先让他比答案多1，最后返回时再-1就行了
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    // Rotate
                    for (int k = 0; k < 2; k++) {
                        if (dp[i][j][k] == 0) {
                            continue; // 等于0说明当前位置不可达，不用计算。
                        }
                        if (i + 1 >= n || j + 1 >= n) {
                            continue; // 如果i+1或j+1超出边界，说明它不可能做翻转操作，因为另一种状态以及越界了。
                        }
                        if (k == 0) { // 水平位置判断下面以及右下位置是否有障碍，没有才能更新
                            if (grid[i + 1][j] != 1 && grid[i + 1][j + 1] != 1)
                            // 如果要更新的状态本来里面存的次数要少，那就不用更新了。
                            {
                                if (dp[i][j][1 - k] == 0 || dp[i][j][1 - k] > dp[i][j][k] + 1)
                                    dp[i][j][1 - k] = dp[i][j][k] + 1;
                            }
                        } else { // 垂直位置判断右边以及右下位置
                            if (grid[i][j + 1] != 1 && grid[i + 1][j + 1] != 1) {
                                if (dp[i][j][1 - k] == 0 || dp[i][j][1 - k] > dp[i][j][k] + 1)
                                    dp[i][j][1 - k] = dp[i][j][k] + 1;
                            }
                        }
                    }

                    // move
                    for (int k = 0; k < 2; k++) {
                        if (dp[i][j][k] == 0) {
                            continue; // 同理当前位置不可达，结束
                        }
                        int[] nx = new int[2], ny = new int[2]; // nx,ny表示蛇身体的位置，前一个是尾巴，后一个是头
                        for (int w = 0; w < 2; w++) { // w循环表示蛇向右移动和向下移动
                            boolean flag = true; // 用于判断蛇是否能到达，就是有没有障碍物
                            nx[0] = i;
                            nx[1] = i + dx[k]; // 计算蛇的身体位置。
                            ny[0] = j;
                            ny[1] = j + dy[k];
                            for (int mv = 0; mv < 2; mv++) { // mv循环表示移动蛇的尾巴和头，先移尾巴后头。
                                nx[mv] += dx[w];
                                ny[mv] += dy[w]; // 计算移动后的位置。
                                if (nx[mv] < 0 || nx[mv] >= n || ny[mv] < 0 || ny[mv] >= n) {
                                    flag = false;
                                }
                                // 如果移动后身体的某个位置超出数组，说明不可达。
                                else if (grid[nx[mv]][ny[mv]] == 1) {
                                    flag = false; // 同样有障碍也不可达。
                                }
                            }
                            if (flag == false) {
                                continue; // 不可达就不能更新。
                            }
                            if (dp[nx[0]][ny[0]][k] == 0 || dp[nx[0]][ny[0]][k] > dp[i][j][k] + 1) {
                                dp[nx[0]][ny[0]][k] = dp[i][j][k] + 1;
                            }
                        }
                    }
                }
            }
            return dp[n - 1][n - 2][0] - 1; // 蛇最后结束的位置就是尾巴在(n-1, n-2)上处于水平状态。然后别忘了之前的-1。
        }
    }

    public static void main(String[] args) {
        new Solution3().removeDuplicates("deeedbbcccbdaa", 3);
    }
}