package Offer.a67剪绳子;

public class Solution {
    public int cutRope(int target) {
        if (target <= 3) {
            return target == 0 ? 0 :
                    target == 1 || target == 2 ? 1 : 2;
        }
        int three = target / 3;
        int two = 0;
        if (target % 3 == 1) {
            two += 2;
            three--;
        }
        if (target % 3 == 2) {
            two++;
        }

        return (int) (Math.pow(3, three) * Math.pow(2, two));
    }
}