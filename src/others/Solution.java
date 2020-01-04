package others;

class Solution {
    public int minDistance(String word1, String word2) {
        int l1 = word1.length();
        int l2 = word2.length();
        int[][] res = new int[l1 + 1][l2 + 1];
        for (int i = 0; i <= l1; i++) {
            res[i][0] = i;
        }
        for (int i = 0; i <= l2; i++) {
            res[0][i] = i;
        }
        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(i - 1)) {
                    res[i][j] = res[i - 1][j - 1];
                } else {
                    res[i][j] = Integer.min(res[i - 1][j - 1], Integer.min(res[i - 1][j], res[i][j - 1])) + 1;
                }
            }
        }
        return res[l1][l2];
    }
}