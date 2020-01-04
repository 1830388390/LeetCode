package LeetCode.A1v300.A221v230.A229MajorityElementII;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        int length = nums.length;
        int limit = length / 3;
        if (length == 0) {
            return res;
        }
        if (length == 1) {
            res.add(nums[0]);
            return res;
        }

        int a = nums[0];
        int b = a;
        int af = 0;
        int bf = 0;
        int i = 0;
        while (i < length) {
            int num = nums[i];
            if (num == a) {
                af++;
                i++;
                continue;
            }
            if (num == b) {
                bf++;
                i++;
                continue;
            }
            if (af == 0){
                a = num;
                i++;
                af++;
                continue;
            }
            if (bf == 0){
                b = num;
                i++;
                bf++;
                continue;
            }
            i++;
            af --;
            bf --;
        }
        af = 0;
        bf = 0;
        for (int j = 0; j < length; j++) {
            if (nums[j] == a) {
                af++;
            } else if (nums[j] == b) {
                bf++;
            }
        }
        if (af >= limit) {
            res.add(a);
        }
        if (bf >= limit) {
            res.add(b);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().majorityElement(new int[]{1, 1, 1, 2, 3, 4, 5, 6});
    }
}