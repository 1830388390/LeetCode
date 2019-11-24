package A1v300.A51v60.A060PermutationSequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        boolean[] used = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
            used[i] = false;
        }
        List<String> pre = new ArrayList<>();
        return dfs(nums, used, n, k, 0, pre);
    }

    private int factorial(int n) {
        // 这种编码方式包括了 0 的阶乘是 1 这种情况
        int res = 1;
        while (n > 0) {
            res *= n;
            n -= 1;
        }
        return res;
    }

    private String dfs(int[] num, boolean[] used, int n, int k, int depth, List<String> pre) {
        if (depth == n) {
            String res = "";
            for (String number : pre) {
                res = res + number;
            }
            return res;
        }

        int possibility = factorial(n - 1 - depth);
        for (int i = 0; i < n; i++) {
            if (used[i]){
                continue;
            }
            if (possibility < k){
                k = k - possibility;
                continue;
            }else {
                used[i] = true;
                pre.add(num[i] + "");
                return dfs(num, used, n, k, depth + 1, pre);
            }
        }
        return "";
    }
}
