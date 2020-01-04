package LeetCode.A1v300.A61v70.A066PlusOne;

class Solution {
    public int[] plusOne(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--){
            if(digits[i] != 9) {
                digits[i]++;
                return digits;
            } else if(i == 0) {
                int[] array = new int[digits.length + 1];
                array[0] = 1;
                return array;
            } else {
                digits[i] = 0;
            }
        }
        return null;
    }
}