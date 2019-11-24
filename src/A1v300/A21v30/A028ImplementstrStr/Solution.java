package A1v300.A21v30.A028ImplementstrStr;

class Solution {
    public int strStr(String haystack, String needle) {
        int h = haystack.length();
        int n = needle.length();
        int start = 0;
        int end = n - 1;
        if (h<n){
            return -1;
        }
        while (end <= h){
            if (haystack.substring(start,end+1).equals(needle)){
                return start;
            }

            end ++;
            start ++;
        }
        return start;
    }
}