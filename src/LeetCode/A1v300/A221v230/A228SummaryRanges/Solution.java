package LeetCode.A1v300.A221v230.A228SummaryRanges;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> summaryRanges(int[] nums) {
        if (nums.length == 0){
            return res;
        }
        ArrayList<Integer> re = new ArrayList<>();
        re.add(nums[0]);
        makeRes(nums,1,re);
        return res;
    }

    private void makeRes(int[] nums,int index,ArrayList<Integer> re){
        if (index>=nums.length){
            addRes(re);
            return;
        }
        if (re.get(re.size() - 1) + 1 == nums[index]){
            re.add(nums[index]);
            makeRes(nums, index + 1, re);
        }else {
            addRes(re);
            ArrayList<Integer> tmp = new ArrayList<>();
            tmp.add(nums[index]);
            makeRes(nums, index + 1, tmp);
        }
    }

    private void addRes(ArrayList<Integer> re){
        if (re.size() == 1){
            res.add(re.get(0).toString());
        }else {
            res.add(re.get(0) + "->" + re.get(re.size() - 1));
        }
    }
}