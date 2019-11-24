package A1v300.A11v20.A017LetterCombinationsofaPhoneNumber;

import java.util.*;

class Solution {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        if (digits.length() !=0){
            makeLetter("",digits);
        }
        return output;
    }

    public void makeLetter (String words , String nextWord){
        if (nextWord.length() == 0){
            output.add(words);
        }
        else {
            for (int i = 0;i<phone.get(nextWord.substring(0,1)).length();i++){
                String w = phone.get(nextWord.substring(0,1)).substring(i,i+1);
                makeLetter(words+w,nextWord.substring(1));
            }
        }
    }
}