package A501v2000.A646MaximumLengthofPairChain;

import java.util.Arrays;

class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a1,a2)->{
            if (a1[0] == a2[0]){
                return a1[1] - a2[1];
            }else {
                return a1[0] - a2[0];
            }
        });
        int length = pairs.length;
        int[] maxLength = new int[length];
        Arrays.fill(maxLength,1);
        int res = 1;
        for (int i = 0;i<length;i++){
            for (int j = i+1;j<length;j++){
                if (pairs[i][1] < pairs[j][0]){
                    maxLength[j] = Integer.max(maxLength[i] + 1,maxLength[j]);
                }
                res = Integer.max(res,maxLength[j]);
            }
        }
        return res;
    }
}