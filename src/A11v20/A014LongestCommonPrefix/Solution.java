package A11v20.A014LongestCommonPrefix;

//["flower","flow","flight"]
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        int min = strs[0].length();
        String minStr = "";
        for (String str : strs) {
            if (str.length() <= min) {
                min = str.length();
                minStr = str;
            }
        }

        for (int size = min; size >= 1; size--) {
            for (int j = 0; j + size-1 <= min - 1; j++) {
                String sub = minStr.substring(j, j + size);
                boolean isFind = true;
                for (String s : strs) {
                    if (s.indexOf(String.valueOf(sub)) != 0) {
                        isFind = false;
                    }
                }
                if (isFind) {
                    return sub;
                }
            }
        }

        boolean isFind = true;
        for (char s : minStr.toCharArray()) {
            for (String str : strs) {
                if (str.indexOf(String.valueOf(s)) != 0) {
                    isFind = false;
                }
            }
            if (isFind) {
                return String.valueOf(s);
            }
        }
        return "";
    }
}