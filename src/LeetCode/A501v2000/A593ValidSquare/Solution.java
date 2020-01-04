package LeetCode.A501v2000.A593ValidSquare;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        List<Integer> ls = new ArrayList<>();
        ls.add(getDistance(p1, p2));
        ls.add(getDistance(p1, p3));
        ls.add(getDistance(p1, p4));
        ls.add(getDistance(p2, p3));
        ls.add(getDistance(p2, p4));
        ls.add(getDistance(p3, p4));
        ls.sort((a1, a2) -> a2 - a1);
        if (ls.get(0).equals(ls.get(1)) &&
                        ls.get(1).equals(ls.get(2)) &&
                        ls.get(2).equals(ls.get(3)) &&
                        ls.get(4).equals(ls.get(5)) &&
                        ls.get(4) > (ls.get(1))){
            return true;
        }else {
            return false;
        }
    }

    private int getDistance(int[] a, int[] b) {
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }
}