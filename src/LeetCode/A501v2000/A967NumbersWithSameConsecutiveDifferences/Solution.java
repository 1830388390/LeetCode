package LeetCode.A501v2000.A967NumbersWithSameConsecutiveDifferences;

import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> res = new HashSet<>();
    int N;
    int K;

    public int[] numsSameConsecDiff(int N, int K) {
        this.N = N;
        this.K = K;
        if (N == 1){
            return new int[]{0,1,2,3,4,5,6,7,8,9};
        }
        for (int i = 1;i<=9;i++){
            DFS(1,i);
        }
        int[] r = new int[res.size()];
        int i = 0;
        for (int tmp : res){
            r[i++] = tmp;
        }
        return r;
    }

    private void DFS(int digit, int tmp) {
        if (digit >= N) {
            res.add(tmp);
            return;
        }
        int last = tmp % 10;
        if (last + K < 10){
            DFS(digit+1,tmp*10+last+K);
        }
        if (last - K >= 0){
            DFS(digit+1,tmp*10+last-K);
        }
    }
}