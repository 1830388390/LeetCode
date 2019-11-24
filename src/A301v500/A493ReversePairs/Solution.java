package A301v500.A493ReversePairs;

import java.util.Arrays;

class Solution {
    public int reversePairs(int[] nums) {
        if (nums.length<=1){
            return 0;
        }

        int[] copy = Arrays.copyOf(nums,nums.length);
        int count = mergeSort2(nums,copy,0,nums.length-1);

        return count;
    }
    int mergeSort2(int[] nums,int[] copy,int begin,int end){
        if(begin == end){
            return 0;
        }
        int mid = (begin + end) / 2;
        int left = mergeSort2(copy,nums, begin, mid);
        int right = mergeSort2(copy,nums, mid + 1, end);

        int li = mid;
        int ri = end;

        int count = 0;
        while (ri>=mid+1 && li >= begin) {
            if ((long)nums[li] > (long)2 * nums[ri]) {
                count += ri-mid;
                li --;
            }
            else {
                ri --;
            }
        }

        int ll = mid,rr=end,index=end;
        while (ll>=begin && rr>=mid+1){
            if (nums[ll]>nums[rr]){
                copy[index--] = nums[ll--];
            }else {
                copy[index--] = nums[rr--];
            }
        }

        while (ll>=begin){
            copy[index--]=nums[ll--];
        }
        while (rr>=mid+1){
            copy[index--]=nums[rr--];
        }

        return left+right+count;
    }

}