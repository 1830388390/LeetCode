package A301v500.A392IsSubsequence;

class Solution {
    public boolean isSubsequence(String s, String t) {
        int lengthS = s.length();
        int lengthT = t.length();
        if (lengthS == 0) {
            return true;
        }
        if (lengthS > lengthT){
            return false;
        }
        int indexS = 0;
        int indexT = 0;
        for (;indexT<lengthT;indexT++){
            if (t.charAt(indexT) == s.charAt(indexS)){
                indexS++;
                if (indexS == lengthS){
                    return true;
                }
            }
            if (lengthS - indexS > lengthT - indexT){
                return false;
            }
        }
        return false;
    }
}