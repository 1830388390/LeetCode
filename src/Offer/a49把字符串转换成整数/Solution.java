package Offer.a49把字符串转换成整数;

public class Solution {
    public int StrToInt(String str) {
        if (str.length() == 0) {
            return 0;
        }
        char[] chars = str.toCharArray();
        int s = chars[0] == '-' ? -1 : 1;
        long res = 0;
        for (int i = chars[0] == '+' || chars[0] == '-' ? 1 : 0; i < chars.length; i++) {
            if (chars[i] >= '0' && chars[i] <= '9') {
                res = res * 10 + chars[i] - '0';
            } else {
                return 0;
            }
        }
        res *= s;
        if (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) res;
    }

    public static void main(String[] args) {
        new Solution().StrToInt("a");
    }
}