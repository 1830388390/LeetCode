package A501v2000.A698PartitiontoKEqualSumSubsets;

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int top = 0;
        int sum = 0;
        if (nums.length == 0){
            return k == 0;
        }
        for (int tmp : nums){
            sum+=tmp;
            top = Integer.max(top,tmp);
        }
        if (sum%k !=0 || top > sum/k){
            return false;
        }
        int[] arrays = new int[k];
        return DFS(new boolean[nums.length],nums,0,0,1,k,sum/k);
    }

    private boolean DFS(boolean[] used,int[] nums,int index,int sum,int times,int k,int target){
        if (times>k){
            return true;
        }
        for (int i = index;i<nums.length;i++){
            if (!used[i] && sum + nums[i] <= target){
                used[i] = true;
                if (sum + nums[i] == target && DFS(used, nums, 1,0, times + 1, k, target) ||
                        DFS(used, nums, i,sum + nums[i], times, k, target)){
                    return true;
                }
                used[i] = false;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /**
         * [605,454,322,218,8,19,651,2220,175,710,2666,350,252,2264,327,1843]
         * 4
         */
        System.out.println(new Solution().canPartitionKSubsets(new int[]{605,454,322,218,8,19,651,2220,175,710,2666,350,252,2264,327,1843},4));
    }
}