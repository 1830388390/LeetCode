package A501v2000.A1186MaximumSubarraySumwithOneDeletion;

class Solution {
    public int maximumSum(int[] arr) {
        int length = arr.length;
        int[] ndel = new int[length];
        int[] del = new int[length];
        ndel[0] = arr[0];
        int res = arr[0];
        for (int i = 1;i<length;i++){
            ndel[i] = Integer.max(ndel[i - 1] + arr[i], arr[i]);
            del[i] = Integer.max(del[i - 1] + arr[i],ndel[i - 1]);
            res = Integer.max(res,Integer.max(ndel[i],del[i]));
        }
        return res;
    }
}