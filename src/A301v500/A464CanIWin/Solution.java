package A301v500.A464CanIWin;

class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int canReachTotal = (1 + maxChoosableInteger) * maxChoosableInteger / 2;
        if (canReachTotal < desiredTotal) { // 达不到
            return false;
        } else if (canReachTotal == desiredTotal) { // 刚好达到，maxChoosableInteger奇数赢
            return (maxChoosableInteger & 1) == 1;
        }

        return canWin(0, desiredTotal, maxChoosableInteger, new int[1 << maxChoosableInteger + 1]);
    }

    private boolean canWin(int nums, int total, int maxNum, int[] dp) {
        if (dp[nums] != 0) {
            return dp[nums] == 1;
        }
        boolean flag = false;
        for (int i = maxNum; i > 0; i--) {
            if ((nums & (1 << i)) == 0) {
                if (i >= total || !canWin(nums | (1 << i), total - i, maxNum, dp)) {
                    flag = true;
                    break;
                }
            }
        }
        dp[nums] = flag ? 1 : 2;
        return flag;
    }
}