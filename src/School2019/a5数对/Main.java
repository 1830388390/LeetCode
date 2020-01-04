package School2019.a5数对;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        /**
         * x / y = k;
         * x + y = n;
         *
         * k * y = n - y
         * y = n / ( k + 1 )
         */
        int y = n / (k + 1);
        System.out.println(n - y);
    }
}
