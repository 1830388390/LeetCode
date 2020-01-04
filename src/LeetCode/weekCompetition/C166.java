package LeetCode.weekCompetition;

import java.util.ArrayList;
import java.util.List;

public class C166 {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {
        ArrayList<Integer>[] tmp = new ArrayList[groupSizes.length + 1];
        for (int i = 0; i <= groupSizes.length; i++) {
            tmp[i] = new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < groupSizes.length; i++) {
            int groupSize = groupSizes[i];
            tmp[groupSize].add(i);
            if (tmp[groupSize].size() == groupSize) {
                List<Integer> t = new ArrayList<>();
                t.addAll(tmp[groupSize]);
                res.add(t);
                tmp[groupSize] = new ArrayList<>();
            }
        }
        return res;
    }

    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = 1;
        for (int n : nums) {
            right = Integer.max(n, right);
        }

        while (left < right) {
            int mid = (left + right) >> 1;
            if (ceilDivision(nums, mid) > threshold) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private int ceilDivision(int[] nums, int divisor) {
        int sum = 0;
        for (int n : nums) {
            sum += (n + divisor - 1) / divisor;
        }
        return sum;
    }


    /**
     * 最小步数
     */
    int step = Integer.MAX_VALUE;
    /**
     * 步数上限,每个点最多改变一次,最多有2^n步
     */
    int maxStep;

    public int minFlips(int[][] mat) {
        maxStep = (int) Math.pow(2, mat.length * mat[0].length) + 1;
        DFS(mat, new boolean[mat.length][mat[0].length], 0);
        return step >= maxStep ? -1 : step;
    }

    private void DFS(int[][] mat, boolean[][] isChanged, int tmpStep) {
        if (isAllZero(mat) || step == maxStep) {
            step = Integer.min(step, tmpStep);
            return;
        }
        /**
         * 遍历每个点,未改变则直接改变
         */
        for (int y = 0; y < mat.length; y++) {
            for (int x = 0; x < mat[0].length; x++) {
                if (!isChanged[y][x]) {
                    changeMat(mat, y, x);
                    isChanged[y][x] = true;
                    DFS(mat, isChanged, tmpStep + 1);
                    changeMat(mat, y, x);
                    isChanged[y][x] = false;
                }
            }
        }
    }

    /**
     * 检查数组是否全0
     */
    private boolean isAllZero(int[][] mat) {
        for (int y = 0; y < mat.length; y++) {
            for (int x = 0; x < mat[0].length; x++) {
                if (mat[y][x] == 1) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 改变当前点数值
     */
    private void changeMat(int[][] mat, int y, int x) {
        mat[y][x] = mat[y][x] == 1 ? 0 : 1;
        if (y - 1 >= 0) {
            mat[y - 1][x] = mat[y - 1][x] == 1 ? 0 : 1;
        }
        if (y + 1 < mat.length) {
            mat[y + 1][x] = mat[y + 1][x] == 1 ? 0 : 1;
        }
        if (x - 1 >= 0) {
            mat[y][x - 1] = mat[y][x - 1] == 1 ? 0 : 1;
        }
        if (x + 1 < mat[0].length) {
            mat[y][x + 1] = mat[y][x + 1] == 1 ? 0 : 1;
        }
    }


    public static void main(String[] args) {
        new C166().groupThePeople(new int[]{3, 3, 3, 3, 3, 1, 3});
    }
}
