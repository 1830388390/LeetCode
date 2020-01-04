package School2019.a3安置路灯;


import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num == 0){
            System.out.println(0);
            return;
        }
        for (int j = 0; j < num; j++) {
            int length = sc.nextInt();
            char[] path = sc.next().toCharArray();
            if (length == 0){
                System.out.println(0);
                break;
            }
            int res = 0;
            int index = 0;
            while (index < length){


            }
            System.out.println(res);
        }
    }

}
