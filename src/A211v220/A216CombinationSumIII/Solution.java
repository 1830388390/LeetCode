package A211v220.A216CombinationSumIII;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        makeRes(k + 1,n,0,new Stack<>());
        return res;
    }
    private void makeRes(int number,int target, int curNum, Stack<Integer> re){
        if(target == 0 && number == 0){
            res.add(new ArrayList<>(re));
            return;
        }
        if (target <= 0 || number <= 0){
            return;
        }
        for (int i = curNum + 1;i<=9;i++){
            re.add(i);
            makeRes( number--,target - i, i, re);
            re.pop();
        }
    }

    public static void main(String[] args) {
        new Solution().combinationSum3(3,7);
    }
}