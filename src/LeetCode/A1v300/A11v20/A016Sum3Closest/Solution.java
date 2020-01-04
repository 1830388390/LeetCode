package LeetCode.A1v300.A11v20.A016Sum3Closest;

import java.util.Arrays;

public class Solution {
    public  int threeSumClosest(int[] nums, int target) {
        int res = 0;
        if (nums.length <= 2) {
            for (int n : nums) {
                res = res + n;
            }
            return res;
        }
        int i = 0;
        int j = 1;
        int k = nums.length - 1;
        int different = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (; i < nums.length - 1; i++) {
            j = i + 1;
            k = nums.length - 1;
            while (j < k){
               // System.out.println(i +"     " + j + "   " + k);
                if (j >= k || i >= k) {
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if (sum > target){
                    k--;
                }
                if (sum<target){
                    j++;
                }
                if (sum == target){
                    System.out.println(target);
                    return target;
                }
                if (different > Math.abs(target - sum)){
                    res = sum;
                    different = Math.abs(target - sum);
                }
            }
        }
        return res;
    }
    public static void main(String[] args) {
        new Solution().threeSumClosest(new int[]{-22,85,-21,-4,-19,91,-54,-50,-4,-27,11,-41,99,32,-4,-70,-42,64,1,30,
                37,59,-89,6,61,-50,57,-85,-10,18,15,6,75,87,-70,-63,-69,-29,29,84,-35,-27,-91,-47,61,13,20,100,-21,3,
                -35,63,87,-95,-94,-71,10,21,76,100,-100,-44,-98,-47,63,-41,-82,68,-28,49,5,-50,-83,15,5,-93,94,91,-81,
                8,-19,6,-19,-34,-69,-69,34,-23,56,-74,19,-31,2,-3,-91,-58,-61,42,-72,-94,-91,-81,-13,-74,8,96,79,-73,14,
                97,-88,-47,86,61,-31,-63,-83,-12,80,30,65,-14,18,57,-29,-2,41,97,4,-15,79,22,-54,-90,-52,-20,78,-93,-54,
                94,1,-31,11,0,17,16,-60,90,-39,46,30,-40,-67,-2,-80,-35,58,90,93,50,-5,-38,70,-11,38,-99,-90,-76,69,76,
                6,96,9,65,-42,-78,-12,-45,41,-90,45,-46,92,-91,-99,74,-43,-34,55,54,45,-76,45},234);
    }
}