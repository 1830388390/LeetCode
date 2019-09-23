package A261v270.A263UglyNumber;

class Solution {
    public boolean isUgly(int num) {
        if (num == 0){
            return false;
        }
        if (num == 1){
            return true;
        }
        if (num%2 == 0 || num%3 == 0 || num%5 == 0){
            return isUgly(num%2 == 0 ? num/2 : (num%3 == 0 ? num/3 : num /5));
        }
        return false;
    }
}