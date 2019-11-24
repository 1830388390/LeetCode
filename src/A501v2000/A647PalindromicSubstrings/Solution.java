package A501v2000.A647PalindromicSubstrings;

class Solution {
    public int countSubstrings(String s) {
        int count = 0;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (i == j) {
                    dp[i][j] = true;
                } else {
                    dp[i][j] = s.charAt(i) == s.charAt(j) && (j - i == 1 || dp[i + 1][j - 1]);
                }
                if (dp[i][j]){
                    count++;
                }
            }
        }
        return count;
    }
}