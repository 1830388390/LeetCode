package LeetCode.A1v300.A51v60.A058LengthofLastWord;

class Solution {
    public int lengthOfLastWord(String s) {
        int l = s.length();
        int res = 0;
        if (l == 0){
            return res;
        }
        int i = l - 1;
        while (i>=0 && s.charAt(i) == ' '){
            i--;
        }
        while (i>=0 && s.charAt(i) != ' ' ){
            i--;
            res++;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().lengthOfLastWord("a");
    }
}