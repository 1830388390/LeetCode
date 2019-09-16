package A161v170.A167TwoSumIIInputarrayissorted;

class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = numbers.length;
        int left = 0;
        int right = l - 1;
        int[] res = new int[2];
        while (left < right){
            if (numbers[left] + numbers[right] > target){
                right --;
            }else if (numbers[left] + numbers[right] < target){
                left ++;
            }else {
                res[0] = left + 1;
                res[1] = right + 1;
                return res;
            }
        }
        return res;
    }
}