package A1v300.A1v10.A008StringtoInteger;

class Solution {
    public static int myAtoi(String str) {
        str = str.trim();
        if (str == null || str.length() == 0) {
            return 0;
        }

        // + - 号
        char firstChar = str.charAt(0);
        int sign = 1;
        int start = 0;
        long res = 0;
        if (firstChar == '+') {
            sign = 1;
            start++;
        } else if (firstChar == '-') {
            sign = -1;
            start++;
        }

        for (int i = start; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return (int) res * sign;
            }
            res = res * 10 + str.charAt(i) - '0';
            if (sign == 1 && res > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && res > Integer.MAX_VALUE) {
                return Integer.MIN_VALUE;
            }
        }
        return (int) res * sign;
    }
    public static void main(String[] args) {
        System.out.println(myAtoi("   +12"));
        System.out.println(myAtoi("   -12"));
        System.out.println(myAtoi(" 2  -12"));
        System.out.println(myAtoi(" ##2  -12"));
        System.out.println(myAtoi("-"));
        System.out.println(myAtoi("-91283472332"));
        System.out.println(myAtoi("3.114"));
        System.out.println(myAtoi("+-3"));
    }
}