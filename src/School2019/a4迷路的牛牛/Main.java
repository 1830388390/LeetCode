package School2019.a4迷路的牛牛;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        String[] res = new String[]{"N", "E", "S", "W"};
        int n = 0;
        String s = sc.next();
        for (int i = 0; i < num; i++) {
            if ('L'==s.charAt(i)) {
                n--;
            } else {
                n++;
            }
            if (n < 0) {
                n = 3;
            }
            if (n > 3) {
                n = 0;
            }
        }
        System.out.println(res[n]);
    }
}
