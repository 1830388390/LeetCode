package A1v300.A31v40.A032LongestValidParentheses;

class Solution {
    public int longestValidParentheses(String s) {
        int l = s.length();
        int maxLength = 0;
        int[] dp = new int[l];
        for (int i = 0; i <= l - 1 ; i++) {
            if (s.charAt(i) == '(') {
                dp[i] = 0;
            }
            if (s.charAt(i) == ')') {
                if (i >= 1 && s.charAt(i - 1) == '('){
                    dp[i] = (i>=2 ? dp[i - 2] : 0) + 2;
                }else if (i >= 1 && i - dp[i - 1] - 1 >=0 && s.charAt(i - dp[i - 1] - 1) == '('){
                    dp[i] = (i - dp[i - 1] - 2 >=0 ? dp[i - dp[i - 1] - 2] : 0 ) + dp[i - 1] + 2;
                }
                maxLength = Math.max(maxLength,dp[i]);
            }
        }
        return maxLength;
    }

}