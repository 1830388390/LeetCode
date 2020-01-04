package LeetCode.A1v300.A181v190.A187RepeatedDNASequences;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new ArrayList<>();
        int l = s.length();
        if (l<10){
            return res;
        }
        Map<String,Integer> phrase = new HashMap<>();
        int end = 9;
        int start = 0;
        for (;end<l;end++){
            phrase.put(
                    s.substring(start,end+1),
                    phrase.getOrDefault(s.substring(start,end+1),0) + 1
            );
            start ++;
        }
        int max = 2;
        for (String tmp : phrase.keySet()){
            max=Integer.max(phrase.get(tmp),max);
        }

        for (String tmp : phrase.keySet()){
            if (phrase.get(tmp) == max){
                res.add(tmp);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().findRepeatedDnaSequences("AAAAAAAAAA");
    }
}