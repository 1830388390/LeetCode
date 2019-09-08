package A131v140.A136SingleNumber;

class Solution {
    public int singleNumber(int[] nums) {
        int i = 0;
        for (int n : nums) {
            i = i ^ n;
        }
        return i;
    }
}