package A501v2000.A1247MinimumSwapstoMakeStringsEqual;

class Solution {
    public int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;
        int x = 0;
        int y = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) == 'x') {
                x++;
            } else {
                y++;
            }
            if (s2.charAt(i) == 'x') {
                x++;
            } else {
                y++;
            }
            if (s1.charAt(i) == 'x' && s2.charAt(i) == 'y') {
                xy++;
                continue;
            }
            if (s1.charAt(i) == 'y' && s2.charAt(i) == 'x') {
                yx++;
                continue;
            }
        }
        if (x != y && x % 2 != 0) {
            return -1;
        }
        System.out.println();
        return xy - xy % 2 + (xy % 2) * 2 + yx - yx % 2;
    }
}