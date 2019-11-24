package A1v300.A161v170.A168ExcelSheetColumnTitle;

class Solution {
    public String convertToTitle(int n) {
        String AZ = "#ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        char[] CZ = AZ.toCharArray();

        StringBuilder sb = new StringBuilder();

        while (n > 0) {
            if (n % 26 == 0) {
                sb.append('Z');
                n = n / 26 - 1;
            } else {
                sb.append(CZ[n % 26]);
                n = n / 26;
            }
        }

        return sb.reverse().toString();

    }

    public static void main(String[] args) {
        System.out.println(new Solution().convertToTitle(702));
    }
}