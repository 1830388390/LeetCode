package A301v500.A416PartitionEqualSubsetSum;

public class Solution {

    /**
     * 常规 0-1 背包问题的写法
     *
     * @param nums
     * @return
     */
    public boolean canPartition(int[] nums) {
        int size = nums.length;

        int s = 0;
        for (int num : nums) {
            s += num;
        }

        // 特判 2：如果是奇数，就不符合要求
        if ((s & 1) == 1 || nums.length == 1) {
            return false;
        }

        int target = s / 2;

        // 创建二维状态数组，行：物品索引，列：容量
        boolean[] dp = new boolean[target + 1];
        // 先写第 1 行

        dp[nums[0]] = true;
        for (int i = 1; i < size; i++) {
            for (int j = target; j >=0; j--) {
                if (j >= nums[i]) {
                    dp[j] = dp[j] || dp[j - nums[i]];
                }
            }
        }

        return dp[target];
    }
}