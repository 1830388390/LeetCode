package A1v300.A231v240.A231PowerofTwo;

class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n == 0){
            return false;
        }
        if (n == 1){
            return true;
        }
        if (n%2 == 1){
            return false;
        }
        return isPowerOfTwo(n/2);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isPowerOfTwo(218));
    }
}