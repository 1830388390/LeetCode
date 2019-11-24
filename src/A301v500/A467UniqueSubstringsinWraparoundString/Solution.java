package A301v500.A467UniqueSubstringsinWraparoundString;

class Solution {
    public int findSubstringInWraproundString(String p) {
        if (p.length() < 1) {
            return 0;
        }
        int res = 0;
        int[] continuityWords = new int[26];
        continuityWords[p.charAt(0)] = 1;
        int length = 1;
        for (int i = 1; i < p.length(); i++) {
            if (p.charAt(i) == 'a' && p.charAt(i - 1) == 'z' || p.charAt(i) - p.charAt(i - 1) == 1) {
                length++;
            } else {
                length = 1;
            }
            continuityWords[p.charAt(i) - 'a'] = Integer.max(length,continuityWords[p.charAt(i) - 'a']);
        }
        for (int i : continuityWords){
            res+=i;
        }
        return res;
    }
}