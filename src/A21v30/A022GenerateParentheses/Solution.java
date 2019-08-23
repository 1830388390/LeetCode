package A21v30.A022GenerateParentheses;

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        if (n == 1){
            res.add("()");
            return res;
        }
        else {
            makeRes(n,"",0,0);
        }
        return res;
    }

    public void makeRes(int n , String words ,int l, int r){
        System.out.println(words);
        if (words.length() == n*2){
            res.add(words);
        }
        if (l<n){
            makeRes(n,words+"(",l+1,r);
        }
        if (l>r){
            makeRes(n,words+")",l,r+1);
        }
    }

    public static void main(String[] args) {
        new Solution().generateParenthesis(3);
    }
}