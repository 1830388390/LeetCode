package A004MedianofTwoSortedArrays;
/*
给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。

请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。

你可以假设 nums1 和 nums2 不会同时为空。

示例 1:

nums1 = [1, 3]
nums2 = [2]

则中位数是 2.0
示例 2:

nums1 = [1, 2]
nums2 = [3, 4]

则中位数是 (2 + 3)/2 = 2.5
 */
import java.util.Map;
import java.util.TreeMap;

class Solution {
    static int m = 0, n = 0;

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int count = nums1.length + nums2.length;
        double result = 0;

        //奇数
        if((count&1) == 1){
            for( int i = 0 ; i < (count/2) ;i ++){
                result = getMax(nums1,nums2);
            }

        }else {
            for( int i = 0 ; i < (count/2) ;i ++){
                if ( m + n == (count/2) - 1){
                    result = (result +getMax(nums1,nums2))/2;
                    break;
                }
                result = getMax(nums1,nums2);
            }
        }
        return result;
    }

    public int getMax(int[] nums1, int[] nums2){
        if (m - 1 > nums1.length){
            return nums2[n++];
        }
        else if(n - 1 > nums2.length){
            return nums1[m++];
        }
        else if (nums1[m] >= nums2[n] && n - 1 > nums2.length){
            return nums2[n++];
        }
        else {
            return nums1[m++];
        }
    }
}












