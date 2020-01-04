package LeetCode.A501v2000.A854KSimilarStrings;

class Solution {
    int res = Integer.MAX_VALUE;
    int length;
    public int kSimilarity(String A, String B) {
        this.length = A.length();
        DFS(A,B,0,0);
        return res;
    }

    private void DFS(String A, String B, int index, int times) {
        if (index == length || A.substring(index).equals( B.substring(index))){
            res = Integer.min(times,res);
            return;
        }
        if (A.charAt(index) == B.charAt(index)){
            DFS(A, B, index + 1, times);
            return;
        }
        if (res<=times){
            return;
        }
        int lastIndex = index + 1;
        while (lastIndex < length && B.indexOf(A.charAt(index),lastIndex)!=-1){
            lastIndex = B.indexOf(A.charAt(index),lastIndex);
            DFS(A, swap(B,index,lastIndex), index + 1, times + 1);
            lastIndex++;
        }
    }

    private String swap(String s,int first,int last){
        StringBuffer sb = new StringBuffer(s);
        char c1 = s.charAt(first);
        char c2 = s.charAt(last);
        sb.replace(first, first + 1, c2 + "");
        sb.replace(last, last + 1, c1 + "");
        return sb.toString();
    }

}