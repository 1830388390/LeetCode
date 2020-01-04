package LeetCode.A501v2000.A650KeysKeyboard;

class Solution {
    public int minSteps(int n) {
        int[] stap = new int[n + 1];
        stap[0] = 0;
        for (int i = 1; i <= n; i++) {
            stap[i] = i;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                if (j%i == 0){
                    stap[j] = Integer.min(stap[j],j/i + stap[i]);
                }
            }
        }
        return n == 1 ? 0 :stap[n];
    }
}