package Offer.a47求1加2加n;

public class Solution {
    public int Sum_Solution(int n) {
        int res = n;
        boolean a = res > 0 && (res += Sum_Solution(n--)) > 0;
        return res;

    }
}