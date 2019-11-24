package A1v300.A31v40.A040CombinationSumII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    private List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        if (candidates.length == 0){
            return res;
        }
        Arrays.sort(candidates);
        makeMiracle(candidates,target,0,new Stack<>());
        return res;
    }

    private void makeMiracle(int[] candidates,int target, int index, Stack<Integer> re){
        if (target == 0){
            res.add(new ArrayList<>(re));
            return;
        }

        for (int i = index;i<=candidates.length - 1 && target - candidates[i] >= 0;i++){
            if (i >index && candidates[i] == candidates[i - 1]){
                continue;
            }
            re.add(candidates[i]);
            makeMiracle(candidates, target - candidates[i], i + 1, re);
            re.pop();
        }
    }
}