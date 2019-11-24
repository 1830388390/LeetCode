package A1v300.A281v290.A290WordPattern;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] s = str.split(" ");
        if (pattern.length() != s.length) {
            return false;
        }
        Set<String> set = new HashSet<>();
        Map<Character, String> map = new HashMap<>();
        for (int i = 0; i < s.length; i++) {
            if (!map.containsKey(pattern.charAt(i)) && !set.contains(s[i])) {
                map.put(pattern.charAt(i), s[i]);
                set.add(s[i]);
                continue;
            }
            if (!map.containsKey(pattern.charAt(i)) && set.contains(s[i])
                    || map.containsKey(pattern.charAt(i)) && !map.get(pattern.charAt(i)).equals(s[i])) {
                return false;
            }
        }
        return true;
    }
}