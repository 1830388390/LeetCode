package School2019.a2被3整除;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();
        int res = 0;
        for (;start<=end;start++){
            if (start%3 != 1){
                res++;
            }
        }
        System.out.println(res);
    }
}
