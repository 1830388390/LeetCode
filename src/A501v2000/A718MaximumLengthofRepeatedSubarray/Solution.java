package A501v2000.A718MaximumLengthofRepeatedSubarray;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findLength(int[] A, int[] B) {
        int[][] dp = new int[A.length + 1][B.length + 1];
        int r = 0;
        for (int i = 0;i<A.length;i++){
            for (int j = 0;j<B.length;j++){
                if (A[i] == B[j]){
                    dp[i+1][j+1] = dp[i][j] + 1;
                    r = Integer.max(dp[i+1][j+1],r);
                }
            }
        }
        return r;
    }
}