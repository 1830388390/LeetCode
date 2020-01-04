package LeetCode.A301v500.A357CountNumberswithUniqueDigits;

class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        int res = 0;
        for (int i = 1;i <=n&&i<=10;i++){
            int tmp = 1;
            int nine = 9;
            int ni = i;
            while (ni>0){
                tmp = tmp * nine--;
                ni--;
            }
            res = res + 9*tmp;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countNumbersWithUniqueDigits(11));
    }
}