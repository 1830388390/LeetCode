package LeetCode.A1v300.A121v130.A125ValidPalindrome;

class Solution {
    private static final char[] charMap = new char[36];

    static {
        // 映射 '0' 到 '9'
        for (int i = 0; i < 10; i++) {
            charMap[i + '0'] = (char) (1 + i); // numeric
        }
        // 映射 'a' 到 'z' 和 映射 'A' 到 'Z'
        for (int i = 0; i < 26; i++) {
            charMap[i + 'a'] = charMap[i + 'A'] = (char) (11 + i);
        }
    }

    public boolean isPalindrome(String s) {
        char[] pChars = s.toCharArray();
        int start = 0, end = pChars.length - 1;
        char cS, cE;
        while (start < end) {
            // 得到映射后的数字
            cS = charMap[pChars[start]];
            cE = charMap[pChars[end]];
            if (cS != 0 && cE != 0) {
                if (cS != cE) {
                    return false;
                }
                start++;
                end--;
            } else {
                if (cS == 0) {
                    start++;
                }
                if (cE == 0) {
                    end--;
                }
            }
        }
        return true;
    }
}