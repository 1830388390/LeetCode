package A151v160.A151ReverseWordsinaString;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        ArrayList<String> tmpS = new ArrayList<>();
        int index = 0;
        while (index < s.length()) {
            while (index <= s.length() && s.charAt(index) == ' ') {
                index++;

            }
            if (index >= s.length()) {
                break;
            }
            int l = index;
            while (l<=s.length() - 1 && s.charAt(l) != ' ') {
                l++;
            }
            if (l == s.length() || s.charAt(l) == ' ') {
                l--;
            }
            tmpS.add(s.substring(index, l + 1));
            index = l + 1;

        }
        if (tmpS.size() == 0) {
            return "";
        }
        int start = 0;
        int end = tmpS.size() - 1;
        while (start <= end) {
            String tmp = tmpS.get(start);
            tmpS.set(start, tmpS.get(end));
            tmpS.set(end, tmp);
            start++;
            end--;
        }
        String res = "";
        for (int i = 0; i < tmpS.size(); i++) {
            res = res + tmpS.get(i) + " ";
        }
        return res.substring(0,res.length() - 1);
    }

    public static void main(String[] args) {
        new Solution().reverseWords("  hello world!  ");
    }
}