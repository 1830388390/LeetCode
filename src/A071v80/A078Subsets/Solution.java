package A071v80.A078Subsets;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

class Solution {
    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        int l = nums.length;
        res.add(new ArrayList<>());
        if (l == 0){
            return res;
        }
        if (l == 1){
            int num = nums[0];
            ArrayList<Integer> r = new ArrayList<>();
            r.add(num);
            res.add(r);
            return res;
        }
        Arrays.sort(nums);
        for (int i = 0;i<=l-1;i++){
            makeRes(nums,l,i,new Stack<>());
        }
        return res;
    }

    private void makeRes(int[] nums, int l, int index, Stack<Integer> re){
        if (l == index){
            res.add(new ArrayList<>(re));
            return;
        }
        for (int i = 0;i<=l-1;i++){
            if (re.size() !=0 && nums[i] <= re.peek()){
                continue;
            }
            re.add(nums[i]);
            makeRes(nums, l, index + 1, re);
            re.pop();
        }
    }
    public static void main(String[] args) {
        new Solution().subsets(new int[]{0});
    }
}