package A501v2000.A873LengthofLongestFibonacciSubsequence;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public int lenLongestFibSubseq(int[] A) {
        int length = A.length;
        Set<Integer> nums = new HashSet<>();
        for (int tmp : A){
            nums.add(tmp);
        }
        int res = 0;
        for (int i = 0;i<length;i++){
            for (int j = i+1;j<length;j++){
                int x = A[i],y = A[j];
                int l = 3;
                while (nums.contains(x + y)){
                    res = Integer.max(res,l);
                    /**         x    y
                     * x , y -> y , x+y -> x+y , x+y+y
                     */
                    int tmp = y;
                    y = y+x;
                    x = tmp;
                    l++;
                }
            }
        }
        return res;
    }
}