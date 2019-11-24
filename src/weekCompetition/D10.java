package weekCompetition;

import java.util.*;

public class D10 {
    class Solution {
        public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
            int[] nums = new int[2000];
            for (int i = 0; i < arr1.length; i++) {
                nums[arr1[i]] = nums[arr1[i]] + 1;
            }
            for (int i = 0; i < arr2.length; i++) {
                nums[arr2[i]] = nums[arr2[i]] + 1;
            }
            for (int i = 0; i < arr3.length; i++) {
                nums[arr3[i]] = nums[arr3[i]] + 1;
            }
            List<Integer> res = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == 3) {
                    res.add(i);
                }
            }
            return res;
        }
    }

    /**
     * Definition for a binary tree node.
     */
    class Solution2 {
        public class TreeNode {
            int val;
            TreeNode left;
            TreeNode right;

            TreeNode(int x) {
                val = x;
            }
        }

        public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
            Set<Integer> r1 = new HashSet<>();
            Set<Integer> r2 = new HashSet<>();
            Queue<TreeNode> nodes = new LinkedList<>();
            if (root1 == null) {
                return false;
            }
            nodes.add(root1);
            while (!nodes.isEmpty()) {
                TreeNode tmp = nodes.remove();
                if (tmp.left != null) {
                    nodes.add(tmp.left);
                }
                if (tmp.right != null) {
                    nodes.add(tmp.right);
                }
                r1.add(tmp.val);
            }

            if (root2 == null) {
                return false;
            }
            nodes.add(root2);
            while (!nodes.isEmpty()) {
                TreeNode tmp = nodes.remove();
                if (tmp.left != null) {
                    nodes.add(tmp.left);
                }
                if (tmp.right != null) {
                    nodes.add(tmp.right);
                }
                r2.add(tmp.val);
            }

            for (int i : r1) {
                if (r2.contains(target - i)) {
                    return true;
                }
            }
            return false;
        }
    }

    static class Solution3 {
        Set<Long> all = new HashSet<>();

        public List<Integer> countSteppingNumbers(int low, int high) {
            all.add(0L);
            for (int i = 1; i < 10; i++) {
                dfs(i);
            }
            List<Integer> res = new ArrayList<>();
            for (long a : all) {
                if (a >= low && a <= high) {
                    res.add((int) a);
                }
            }
            Collections.sort(res);
            return res;
        }

        void dfs(long cur) {
            if (cur > Integer.MAX_VALUE) {
                return;
            }
            all.add(cur);
            long now = (cur % 10);
            if (now > 0) {
                dfs(cur * 10 + now - 1);
            }
            if (now < 9) {
                dfs(cur * 10 + now + 1);
            }
        }
    }

    class Solution4 {
        int[][] dp;
        int n;
        String s;

        public boolean isValidPalindrome(String s, int k) {
            this.s = s;
            n = s.length();
            dp = new int[n][n];
            for (int i = 0; i < n; i++) {
                Arrays.fill(dp[i], -1);
            }
            int tmp = solve(0, n - 1);
            return n - tmp <= k;
        }

        int solve(int l, int r) {
            if (l > r) return 0;
            if (l == r) return 1;
            if (dp[l][r] != -1) return dp[l][r];
            int res = solve(l + 1, r);
            res = Math.max(res, solve(l, r - 1));
            if (s.charAt(l) == s.charAt(r)) {
                int tmp = solve(l + 1, r - 1) + 2;
                res = Math.max(res, tmp);
            }
            return dp[l][r] = res;
        }
    }

    public static void main(String[] args) {
        new Solution3().countSteppingNumbers(0, 10000);
    }
}
