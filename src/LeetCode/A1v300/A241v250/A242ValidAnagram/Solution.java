package LeetCode.A1v300.A241v250.A242ValidAnagram;

class Solution {
    public boolean isAnagram(String s, String t) {
        int[] sChar = new int[26];
        int[] tChar = new int[26];
        for (char a : s.toCharArray()){
            sChar[a - 'a']++;
        }
        for (char a : t.toCharArray()){
            tChar[a - 'a']++;
        }
        for (int i = 0;i<26;i++){
            if (sChar[i] != tChar[i]){
                return false;
            }
        }
        return true;
    }
}