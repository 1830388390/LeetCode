package LeetCode.A1v300.A61v70.A070ClimbingStairs;

class Solution {
    public int climbStairs(int n) {
        if (n == 0){
            return 0;
        }
        if (n == 1){
            return 1;
        }
        int[] times = new int[n];
        for (int i = n - 1;i>=0;i--){
            if (i == n-1){
                times[n-1] = 1;
                continue;
            }
            if (i == n-2){
                times[n-2] = 2;
                continue;
            }
            times[i] = times[i+1] + times[i+2];
        }
        return times[0];
    }
}