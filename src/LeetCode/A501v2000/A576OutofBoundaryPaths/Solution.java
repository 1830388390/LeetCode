package LeetCode.A501v2000.A576OutofBoundaryPaths;

class Solution {
    long res = 0;
    int[][][] mem;

    public int findPaths(int m, int n, int N, int i, int j) {
        mem = new int[m + 1][n + 1][N + 1];
        makeRes(m, n, N, i, j);
        return (int) res % 1000000007;
    }

    private int makeRes(int m, int n, int N, int i, int j) {
        if (N == -1) {
            return 0;
        }
        if (mem[m][n][N] != 0) {
            return mem[m][n][N];
        }
        if (i < 0 || i >= m || j < 0 || j >= n) {
            res++;
            return 1;
        }
        mem[m][n][N] = makeRes(m, n, N - 1, i + 1, j)+
        makeRes(m, n, N - 1, i, j + 1)+
        makeRes(m, n, N - 1, i - 1, j)+
        makeRes(m, n, N - 1, i, j - 1);
        return mem[m][n][N];
    }

    public static void main(String[] args) {
        new Solution().findPaths(10,10,10,0,0);
    }
}