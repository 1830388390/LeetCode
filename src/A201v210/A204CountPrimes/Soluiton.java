package A201v210.A204CountPrimes;

class Solution {
    public int countPrimes(int n) {
        int res = 0;
        if (n<=2){
            return res;
        }
        boolean[] nums = new boolean[n+1];
        for (int i = 2;i<n;i++){
            if (nums[i]){
                continue;
            }else {
                for (int j = 2;i*j<=n;j++){
                    nums[i*j] = true;
                }
                res++;
            }
        }
        return res;
    }
}