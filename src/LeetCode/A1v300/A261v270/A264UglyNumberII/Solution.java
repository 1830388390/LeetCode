package LeetCode.A1v300.A261v270.A264UglyNumberII;

class Solution {
    public int nthUglyNumber(int n) {
        if (n == 0) {
            return 0;
        }
        int[] res = new int[n];
        res[0] = 1;
        int index1 = 0;
        int index2 = 0;
        int index3 = 0;
        for (int i = 1; i < n; i++) {
            res[i] = Integer.min(res[index1] * 2, Integer.min(res[index2] * 3, res[index3] * 5));
            if(res[i] == res[index1] * 2){index1++;}
            if(res[i] == res[index2] * 3){index2++;}
            if(res[i] == res[index3] * 5){index3++;}
        }
        return res[n-1];
    }
    public static void main(String[] args) {
        new Solution().nthUglyNumber(11);
    }
}