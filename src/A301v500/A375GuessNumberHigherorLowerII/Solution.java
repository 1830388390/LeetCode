package A301v500.A375GuessNumberHigherorLowerII;

class Solution {
    public int getMoneyAmount(int n) {
        int res = 0;
        int tmp = 0;
        while (tmp != n){
            tmp = tmp + (n - tmp + 1)/2;
            res = res + tmp;
        }
        return res;
    }
}