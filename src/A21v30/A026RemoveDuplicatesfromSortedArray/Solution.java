package A21v30.A026RemoveDuplicatesfromSortedArray;

import java.util.HashMap;
import java.util.Map;

class Solution {
    static int i = 0;

    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i= 0;i<nums.length;i++){
            map.put(nums[i],0);
        }


        for (int a : map.keySet()){
            if (i>nums.length){break;}
            nums[i]=a;
            i++;
        }

        return map.size();
    }
}