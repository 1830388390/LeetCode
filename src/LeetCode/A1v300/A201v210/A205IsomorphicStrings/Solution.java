package LeetCode.A1v300.A201v210.A205IsomorphicStrings;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character,Character> words = new HashMap<>(16);
        boolean[] isUsed = new boolean[256];
        for (int i = 0;i<s.length();i++){
            if (words.containsKey(s.charAt(i))){
                if (t.charAt(i) == words.get(s.charAt(i)) ){
                }else {
                    return false;
                }
            }else {
                if (isUsed[t.charAt(i)]){
                    return false;
                }
                words.put(s.charAt(i),t.charAt(i));
                isUsed[t.charAt(i)] = true;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("ab","aa"));
    }
}