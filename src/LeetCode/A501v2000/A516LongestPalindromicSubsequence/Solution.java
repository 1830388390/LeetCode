package LeetCode.A501v2000.A516LongestPalindromicSubsequence;

class Solution {
    public int longestPalindromeSubseq(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int[][] dp = new int[length + 1][length + 1];
        for (int i = 0; i < length; i++) {
            for (int j = length - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i + 1][length - j] = dp[i][length - 1 - j] + 1;
                } else {
                    dp[i + 1][length - j] = Integer.max(dp[i][length - j],dp[i + 1][length - j - 1]);
                }
            }
        }
        return dp[length][length];
    }
}