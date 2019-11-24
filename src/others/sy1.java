package others;

import java.util.Scanner;


public class sy1 {
    public String isTriangle() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入a: ");
        String read = s.nextLine();
        System.out.println("请输入b: ");
        String read2 = s.nextLine();
        System.out.println("请输入c: ");
        String read3 = s.nextLine();
        if (read.equals("") || read2.equals("") || read3.equals("")) {
            return "请输入数据";
        }
        if (read.contains(".") || read2.contains(".") || read3.contains(".")) {
            return "输入非法";
        }
        int a = Integer.valueOf(read);
        int b = Integer.valueOf(read2);
        int c = Integer.valueOf(read3);
        if (a <= 0 || b <= 0 || c <= 0
                || a > 100 || b > 100 || c > 100) {
            return "输入非法";
        }
        if (a + b <= c || a + c <= b || b + c <= a) {
            return "不能构成三角形";
        }
        if (a == b && b == c) {
            return "等边三角形";
        }
        if (a == b || a == c || c == b) {
            return "等腰三角形";
        }
        return "一般三角形";
    }

    public String getNextData() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入月份: ");
        String read = s.nextLine();
        System.out.println("请输入日期: ");
        String read2 = s.nextLine();
        System.out.println("请输入年份: ");
        String read3 = s.nextLine();

        if (read.equals("") || read2.equals("") || read3.equals("")) {
            return "请输入数据";
        }
        int month = Integer.valueOf(read);
        int day = Integer.valueOf(read2);
        int year = Integer.valueOf(read3);

        int[] monthDays = new int[]{0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 4 == 0) {
            monthDays[2] = 29;
        }
        if (month > 12 || month <= 0 || day > monthDays[month]
                || year > 2050 || year < 1900) {
            return "输入越界";
        }
        int newDay = day + 1;
        int newMonth = month;
        int newYear = year;
        if (newDay > monthDays[month]) {
            newDay = 1;
            newMonth = month + 1;
            if (newMonth > 12) {
                newYear = newYear + 1;
                newMonth = 1;
            }
        }
        return newYear + "." + newMonth + "." + newDay;
    }

    public static void main(String[] args) {
        System.out.println(new sy1().isTriangle());
        System.out.println(new sy1().getNextData());
    }
}
