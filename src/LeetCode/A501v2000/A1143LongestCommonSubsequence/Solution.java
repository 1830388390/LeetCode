package LeetCode.A501v2000.A1143LongestCommonSubsequence;

class Solution {

    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] res = new int[l1 + 1][l2 + 1];
        for (int i = 0; i < l1; i++) {
            for (int j = 0; j < l2; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    res[i + 1][j + 1] = res[i][j] + 1;
                }else {
                    res[i + 1][j + 1] = Integer.max(res[i][j+1],res[i+1][j]);
                }
            }
        }
        return res[l1][l2];
    }
}