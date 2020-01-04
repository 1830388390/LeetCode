package LeetCode.A1v300.A291v300.A299BullsandCows;

class Solution {
    public String getHint(String secret, String guess) {
        int[] b1 = new int[10];
        int[] b2 = new int[10];
        int bulls = 0, cows = 0;
        //统计俩字符串各个数字的频次，顺带统计bulls的个数
        for(int i = 0, j = 0; i < secret.length() || j < guess.length(); i++, j++){
            if(i < secret.length() && j < guess.length()) {
                b1[secret.charAt(i) - '0']++;
                b2[guess.charAt(j) - '0']++;
                bulls += secret.charAt(i) == guess.charAt(j) ? 1 : 0;
            }else if(i == secret.length()) {
                b2[guess.charAt(j) - '0']++;
            }else if(j == guess.length()) {
                b1[secret.charAt(i) - '0']++;
            }
        }
        //统计cows的个数
        for(int i = 0; i < b1.length; i++) {
            cows += Math.min(b1[i], b2[i]);
        }
        cows -= bulls;
        String res = String.format("%dA%dB", bulls, cows);
        return res;
    }
}