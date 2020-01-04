package LeetCode.A1v300.A131v140.A131PalindromePartitioning;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<String>> res = new ArrayList<>();
    public List<List<String>> partition(String s) {

        makeRes(s,0,0,new ArrayList<>(),s.length());
        return res;
    }

    private void makeRes(String s,int start,int end,List<String> re,int l){
        if (start == end && end == l -1){
            re.add(s.substring(l-1,l));
            res.add(re);
        }
        if (isPalindrome(s,start,end)){
            re.add(s.substring(start,end + 1));
        }
        for (int i = end + 1;i<=l-1;i++){
            makeRes(s, end + 1, i, re, l);
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (s.charAt(start) == s.charAt(end)) {
            return isPalindrome(s, start + 1, end - 1);
        }
        return false;
    }

}