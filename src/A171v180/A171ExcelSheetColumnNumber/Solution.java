package A171v180.A171ExcelSheetColumnNumber;

class Solution {
    public int titleToNumber(String s) {
        int l = s.length();
        int res = 0;
        for (int i = 0;i<l;i++){
            int num =  (s.charAt(i) - 64);
            res = res*26 + num;
        }
        return res;
    }
}