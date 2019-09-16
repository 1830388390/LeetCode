package A201v210.A202HappyNumber;

class Solution {
    public boolean isHappy(int n) {
        if (n == 0) {
            return false;
        }
        return makeRes(String.valueOf(n));
    }

    private boolean makeRes(String n) {
        int res = 0;
        for (char a : n.toCharArray()) {
            a = (char) (a - '0');
            res = a * a + res;
        }
        if (res == 4) {
            return false;
        } else if (res == 1) {
            return true;
        } else {
            return makeRes(String.valueOf(res));
        }
    }

    public static void main(String[] args) {
        new Solution().isHappy(19);
    }
}