package A067AddBinary;

import java.util.Collections;

class Solutions {
    public String addBinary(String a, String b) {
        int lengtha = a.length();
        int lengthb = b.length();
        int maxLength = Math.max(lengtha, lengthb);
        StringBuffer result = new StringBuffer(String.join("", Collections.nCopies(maxLength, "0")));
        String ra = String.join("", Collections.nCopies(maxLength - a.length(), "0")) + a;
        String rb = String.join("", Collections.nCopies(maxLength - b.length(), "0")) + b;
        for (int i = maxLength - 1; i > 0; i--) {
            int l = ra.charAt(i) + rb.charAt(i) - '0' - '0' + result.charAt(i)-'0';
            if (l == 2) {
                result.setCharAt(i, '0');
                result.setCharAt(i - 1, '1');
            } else if (l == 3) {
                result.setCharAt(i, '1');
                result.setCharAt(i - 1, '1');
            } else if(l==1){
                result.setCharAt(i, '1');
            }
        }
        int first = result.charAt(0) + ra.charAt(0) + rb.charAt(0) - '0' - '0'-'0';
        if (first == 2) {
            result.setCharAt(0, '0');
            result.insert(0, '1');
        } else if (first == 3) {
            result.insert(0, '1');
        }else if(first==1){
            result.setCharAt(0, '1');
        }
        return result.toString();
    }

    public static void main(String[] args) {
        Solutions s = new Solutions();
        System.out.println(s.addBinary("11", "11"));
    }
}