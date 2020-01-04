package LeetCode.A301v500.A474OnesandZeroes;

class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int res = 0;
        for (String s : strs){
            int zero = getZeroAndOne(s)[0];
            int one = getZeroAndOne(s)[1];
            for (int i = m;i>=zero;i++){
                for (int j = n;j>=one;j++){
                    dp[i][j] = Integer.max(1 + dp[i - zero][j - one],dp[i][j]);
                }
            }
        }
        return dp[m][n];
    }
    private int[] getZeroAndOne(String str){
        int zero = 0;
        int one = 0;
        for (char c : str.toCharArray()){
            if (c == '1'){
                one++;
            }else {
                zero++;
            }
        }
        return new int[]{zero,one};
    }
}