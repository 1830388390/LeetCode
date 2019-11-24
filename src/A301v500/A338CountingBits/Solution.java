package A301v500.A338CountingBits;

class Solution {
    public int[] countBits(int num) {
        if (num == 0){
            return new int[]{0};
        }
        if (num == 1){
            return new int[]{0,1};
        }
        int square = 2;
        int[] res = new int[num + 1];
        res[0] = 0;
        res[1] = 1;
        for (int i = 2;i<=num;i++){
            if (i/square == 1){
                res[i] = res[i - square] + 1;
            }else {
                square = square * 2;
                res[i] = res[i - square] + 1;
            }
        }
        return res;
    }
}