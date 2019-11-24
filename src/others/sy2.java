package others;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;


public class sy2 {

    public String getReimbursement()  {
        String type;
        int level;
        int times;
        int money;
        Scanner s = new Scanner(System.in);
        System.out.print("请输入人员类别(在职,退休,老工人,退休劳模) ：");
        String read = s.nextLine();
        System.out.print("请输入医院级别（1,2,3） ：");
        String read2 = s.nextLine();
        System.out.print("请输入报销次数 ：");
        String read3 = s.nextLine();
        System.out.print("请输入花费金额 ：");
        String read4 = s.nextLine();
        if (read.equals("") || read2.equals("") || read3.equals("") || read4.equals("")) {
            return "请重新输入！";
        }
        type = read;
        level = Integer.valueOf(read2);
        times = Integer.valueOf(read3);
        money = Integer.valueOf(read4);
        Set<String> types = new HashSet<>(4);
        types.add("在职");
        types.add("退休");
        types.add("老工人");
        types.add("退休劳模");
        if (level<0 || times<0 || money<0 || level>3 || !types.contains(type)) {
            return "请重新输入！";
        }
        int standard = 0;
        double reimbursement = 0;
        switch (level) {
            case 1:
                standard = times >= 2 ? 270 : 800;
                break;
            case 2:
                standard = times >= 2 ? 350 : 1100;
                break;
            case 3:
                standard = times >= 2 ? 500 : 1700;
                break;
            default:
                break;
        }
        int typeNum = type.equals("在职") ? 1 :
                type.equals("退休") ? 2 :
                        type.equals("老工人") ? 3 :
                                type.equals("退休劳模") ? 4 : 0;
        switch (typeNum) {
            case 1:
                if (money >= standard && money <= 55000) {
                    reimbursement = (money - standard) * 0.85;
                    break;
                }
                if (money > 55000 && money <= 150000) {
                    reimbursement = (55000 - standard) * 0.85 + (money - 55000) * 0.8;
                    break;
                }
                if (money > 150000) {
                    reimbursement = (150000 - 55000) * 0.8 + (55000 - standard) * 0.85;
                    break;
                }
                break;
            case 2:
                if (money >= standard && money <= 55000) {
                    reimbursement = (money - standard) * 0.9;
                    break;
                }
                if (money > 55000 && money <= 150000) {
                    reimbursement = (55000 - standard) * 0.9 + (money - 55000) * 0.8;
                    break;
                }
                if (money > 150000) {
                    reimbursement = (150000 - 55000) * 0.8 + (55000 - standard) * 0.9;
                    break;
                }
                break;
            case 3:
                if (money >= standard && money <= 55000) {
                    reimbursement = (money - standard) * 0.95;
                    break;
                }
                if (money > 55000 && money <= 150000) {
                    reimbursement = (55000 - standard) * 0.95 + (money - 55000) * 0.8;
                    break;
                }
                if (money > 150000) {
                    reimbursement = (150000 - 55000) * 0.8 + (55000 - standard) * 0.95;
                    break;
                }
                break;
            case 4:
                if (money >= standard && money <= 55000) {
                    reimbursement = (money - standard) * 0.95;
                    break;
                }
                if (money > 55000 && money <= 150000) {
                    reimbursement = (55000 - standard) * 0.95 + (money - 55000) * 0.8;
                    break;
                }
                if (money > 150000) {
                    reimbursement = (150000 - 55000) * 0.8 + (55000 - standard) * 0.95;
                    break;
                }
                break;
            default:
                break;
        }
        return String.format("%.2f", reimbursement);
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println(new sy2().getReimbursement());
        }
    }
}

