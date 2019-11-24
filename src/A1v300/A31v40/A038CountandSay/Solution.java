package A1v300.A31v40.A038CountandSay;

class Solution {
    public String countAndSay(int n) {
        String begin = "1";
        while (n>1){
            begin = getNextNum(begin);
            n--;
        }
        return String.valueOf(begin);
    }
    String getNextNum(String num){
        String str = String.valueOf(num);
        char begin = str.charAt(0);
        int times = 0;
        String res = "";
        for (int i =0;i<=str.length() - 1;i++){
            if (str.charAt(i) == begin){
                times ++;
            }else {
                res = res + times + begin ;
                times = 1;
                begin = str.charAt(i);
            }
        }
        res = res + times + begin ;
        return res;
    }
}