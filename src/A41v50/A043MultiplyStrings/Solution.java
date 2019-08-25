package A41v50.A043MultiplyStrings;

class Solution {
    public String multiply(String num1, String num2) {
        if (num1 .equals("0") || num2.equals("0")) {
            return "0";
        }
        int l = num1.length() + num2.length();
        int[] res = new int[l];
        for (int i = num1.length() - 1; i >= 0; i--) {
            if (num1.charAt(i) != '0') {
                for (int j = num2.length() - 1; j >= 0; j--) {
                    if (num2.charAt(j) != '0') {
                        int multiplyRes = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                        add(res, j+i+1, multiplyRes);
                    }
                }
            }
        }

        String str = "";
        if (res[0] == 0){
            for (int i = 1;i<l;i++){
                str = str + String.valueOf(res[i]);
            }
        }
        else {
            for (int i = 0;i<l;i++){
                str = str + String.valueOf(res[i]);
            }
        }
        return str;
    }

    private int[] add(int[] nums, int index, int addNum) {
        if (addNum == 0) {
            return nums;
        }
        int num = nums[index] + addNum;
        if (num > 9) {
            nums[index] = num % 10;
            return add(nums, index - 1, num / 10);
        } else {
            nums[index] = num;
            return nums;
        }
    }

    public static void main(String[] args) {
        new Solution().multiply("112451","222453");
    }
}


