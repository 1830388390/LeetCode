package A61v70.A069Sqrtx;

class Solution {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1;
        int h = x;
        while (l < h) {
            int mid = l + (h - l) / 2;
            if (x/mid >=mid) {
                l = mid+1;
            } else {
                h = mid;
            }
        }
        return h-1;
    }

    public static void main(String[] args) {
        new Solution().mySqrt(100);
    }
}