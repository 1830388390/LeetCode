package A201v210.A201BitwiseANDofNumbersRange;

class Solution {
    public int rangeBitwiseAnd(int m, int n) {
        int res = m;
        if (res == 0){
            return 0;
        }
        for (int i = m;i<=n;i++){
            res = res&i;
        }
        return res;
    }
}