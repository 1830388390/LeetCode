package A1v300.A81v90.A090SubsetsII;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);
        List<List<Integer>> lists = new ArrayList<>();
        int subsetNum = 1<<num.length;
        for(int i=0;i<subsetNum;i++){
            List<Integer> list = new ArrayList<>();
            boolean illegal=false;
            for(int j=0;j<num.length;j++){
                //当前位是 1
                if((i>>j&1)==1){
                    //当前是重复数字，并且前一位是 0，跳过这种情况
                    if(j>0&&num[j]==num[j-1]&&(i>>(j-1)&1)==0){
                        illegal=true;
                        break;
                    }else{
                        list.add(num[j]);
                    }
                }
            }
            if(!illegal){
                lists.add(list);
            }

        }
        return lists;
    }
}

class Solution2 {
    //2 ms, 在所有 Java 提交中击败了96.01%的用户

    //参考了大神的代码，自己理解了一下
    //
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        if(nums == null || nums.length == 0){
            return ans;
        }
        List<Integer> item = new ArrayList<>();
        Arrays.sort(nums);
        process(nums,0,item,ans);
        return ans;
    }

    public void process(int[] nums,int start,List<Integer> item,List<List<Integer>> ans){
        ans.add(new ArrayList<>(item));

        //加入数据为122345
        //在第一个2面对于前面传过来的item，
        //可以把自己添加到item,然后继续递归，
        //在它的子树中包括了第2个2被选和不被选两种可能
        //即 item + 2 +  2  + rest
        //   item + 2 + " " + rest
        //所以在状态重置的时候，把第一个2删掉之后
        //把item给了第2个2的时候，就不要递归了
        //因为这种情况就相当于 item + " " + 2 + rest
        //这就和item + 2 + " " + rest一样了
        //所以直接不选把item + " " + " "给 第i + 2位
        for(int i = start; i < nums.length; i++){
            if(i > start && nums[i] == nums[i - 1]){
                continue;
            }


            item.add(nums[i]);
            process(nums,i + 1,item,ans);
            item.remove(item.size() - 1);
        }

    }
}