package LeetCode.A1v300.A31v40.A039CombinationSum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {

    private List<List<Integer>> res = new ArrayList<>();
    private int[] candidates;
    private int len;

    public void findCombinationSum(int target , int index , Stack<Integer> r){
        if (target == 0){
            res.add(new ArrayList<>(r));
            return;
        }

        for (int i = index;i <= candidates.length - 1 && target - candidates[i] >=0;i++){
            r.add(candidates[i]);
            findCombinationSum(target- candidates[i], i, r);
            r.pop();
        }
    }


    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }
        // 优化添加的代码1：先对数组排序，可以提前终止判断
        Arrays.sort(candidates);
        this.len = len;
        this.candidates = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }

}
