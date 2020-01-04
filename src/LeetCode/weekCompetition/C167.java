package LeetCode.weekCompetition;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class C167 {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    int res;
    int length;

    public int getDecimalValue(ListNode head) {


        this.length = 0;
        ListNode tmp = head;
        while (tmp != null) {
            tmp = tmp.next;
            length++;
        }
        sum(head, 1);
        return res;
    }

    private void sum(ListNode head, int livel) {
        if (head == null) {
            return;
        }
        if (head.next == null && head.val == 0) {
            return;
        }
        res += Math.pow(head.val == 1 ? 2 : 0, length - livel);
        sum(head.next, livel + 1);
    }

    int[][] sumMatrix;

    public int maxSideLength(int[][] mat, int threshold) {
        int height = mat.length;
        int wide = mat[0].length;
        sumMatrix = new int[height][wide];
        int res = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < wide; x++) {
                sumMatrix[y][x] += mat[y][x];
                if (x > 0) {
                    sumMatrix[y][x] += sumMatrix[y][x - 1];
                }
            }
        }
        for (int x = 0; x < wide; x++) {
            for (int y = 1; y < height; y++) {
                sumMatrix[y][x] += sumMatrix[y - 1][x];
            }
        }

        int tmpSum = 0;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < wide; x++) {
                tmpSum += mat[y][x];
            }
        }
        if (tmpSum == sumMatrix[height - 1][wide - 1]) {
            System.out.println(tmpSum);
        }

        for (int y1 = 0; y1 < height; y1++) {
            for (int x1 = 0; x1 < wide; x1++) {
                for (int w = 0; w < Math.min(height, wide); w++) {
                    int y2 = y1 + w;
                    int x2 = x1 + w;
                    if (y2 >= height || x2 >= wide) {
                        break;
                    }
                    if (getSum(y1, x1, y2, x2) <= threshold) {
                        res = Integer.max(w + 1, res);
                    }
                }
            }
        }
        return res;

    }

    private int getSum(int y1, int x1, int y2, int x2) {
        int allSum = sumMatrix[y2][x2];
        int left = x1 - 1 > 0 ? sumMatrix[y1][x1 - 1] : 0;
        int up = y1 - 1 > 0 ? sumMatrix[y1 - 1][x1] : 0;
        int leftUp = x1 - 1 > 0 && y1 - 1 > 0 ? sumMatrix[y1 - 1][x1 - 1] : 0;
        return allSum - left - up + leftUp;
    }


    int height;
    int wide;
    int step = Integer.MAX_VALUE;

    public int shortestPath(int[][] grid, int k) {
        height = grid.length;
        wide = grid[0].length;
//        DFS(grid, 0, 0, k, 0, new boolean[height][wide]);
        BFS(grid, k);
        return step == Integer.MAX_VALUE ? -1 : step;
    }

    private void DFS(int[][] grid, int y, int x, int k, int tmpStep, boolean[][] isUsed) {

        if (y < 0 || x < 0 || x >= wide || y >= height || isUsed[y][x] || k < 0 || tmpStep > step) {
            return;
        }

        if (y == height - 1 && x == wide - 1) {
            step = Integer.min(tmpStep, step);
            return;
        }

        if (grid[y][x] == 1) {
            grid[y][x] = 0;
            isUsed[y][x] = true;
            DFS(grid, y - 1, x, k - 1, tmpStep + 1, isUsed);
            DFS(grid, y, x - 1, k - 1, tmpStep + 1, isUsed);
            DFS(grid, y + 1, x, k - 1, tmpStep + 1, isUsed);
            DFS(grid, y, x + 1, k - 1, tmpStep + 1, isUsed);
            grid[y][x] = 1;
            isUsed[y][x] = false;
        } else {
            DFS(grid, y - 1, x, k, tmpStep + 1, isUsed);
            DFS(grid, y, x - 1, k, tmpStep + 1, isUsed);
            DFS(grid, y + 1, x, k, tmpStep + 1, isUsed);
            DFS(grid, y, x + 1, k, tmpStep + 1, isUsed);
        }
    }

    class Node {
        int y;
        int x;
        int k;
        boolean[][] used;

        public Node(int y, int x, int k, boolean[][] used) {
            this.y = y;
            this.x = x;
            this.k = k;
            this.used = used;
        }
    }

    private void BFS(int[][] grid, int allK) {
        Queue<Node> bfsQueue = new LinkedList<>();
        bfsQueue.add(new Node(0, 0, allK, new boolean[grid.length][grid[0].length]));
        int tmpStep = 0;
        while (!bfsQueue.isEmpty()) {
            int size = bfsQueue.size();
            for (int i = 0; i < size; i++) {
                Node tmp = bfsQueue.remove();
                int y = tmp.y;
                int x = tmp.x;
                int k = tmp.k;
                if (y < 0 || x < 0 || x >= wide || y >= height || tmp.used[y][x] || k < 0) {
                    continue;
                }
                if (x == wide - 1 && y == height - 1) {
                    step = tmpStep;
                    return;
                }
                boolean[][] t = tmp.used.clone();
                t[y][x] = true;
                if (grid[y][x] == 1) {
                    bfsQueue.add(new Node(y - 1, x, k - 1, t));
                    bfsQueue.add(new Node(y, x - 1, k - 1, t));
                    bfsQueue.add(new Node(y + 1, x, k - 1, t));
                    bfsQueue.add(new Node(y, x + 1, k - 1, t));
                } else {
                    bfsQueue.add(new Node(y - 1, x, k, t));
                    bfsQueue.add(new Node(y, x - 1, k, t));
                    bfsQueue.add(new Node(y + 1, x, k, t));
                    bfsQueue.add(new Node(y, x + 1, k, t));
                }
            }
            tmpStep++;
        }
    }



    class Solution {
        private int[][] dir = new int[][] {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        public int shortestPath(int[][] grid, int k) {
            int m = grid.length;
            int n = grid[0].length;
            boolean[][][] visited = new boolean[m][n][k + 1];
            Queue<Point> queue = new LinkedList<>();

            queue.add(new Point(0, 0, 0));

            // **核心逻辑**：访问记录二维扩展为三维
            visited[0][0][0] = true;

            int distance = 0;
            while (!queue.isEmpty()) {
                distance++;

                int size = queue.size();

                for (int i = 0; i < size; i++) {

                    Point point = queue.poll();

                    int x = point.x;
                    int y = point.y;
                    int z = point.z;

                    // 找到障碍物
                    if (x == m - 1 && y == n - 1) {
                        return distance -1;
                    }

                    // 4个方向移动
                    for (int j = 0; j < 4; j++) {
                        int newX = x + dir[j][0];
                        int newY = y + dir[j][1];
                        int newZ = z;

                        if (newX < 0 || newX >= m || newY < 0 || newY >= n) {
                            continue;
                        }

                        // **核心逻辑**：有障碍物要对其进行处理，计算是否还能消除障碍物
                        if (grid[newX][newY] == 1) {
                            // 没有消除 k 个障碍物，可以继续消除
                            if (z < k) {
                                newZ = z + 1;
                            } else {
                                // 已经消除 k 个障碍物
                                continue;
                            }
                        }

                        if (!visited[newX][newY][newZ]) {
                            queue.add(new Point(newX, newY, newZ));
                            visited[newX][newY][newZ] = true;
                        }
                    }
                }
            }
            return -1;
        }

        class Point {
            int x;

            int y;

            int z;

            public Point(int x, int y, int z) {
                this.x = x;
                this.y = y;
                this.z = z;
            }
        }
    }



}
