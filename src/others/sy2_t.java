package others;

import java.util.HashSet;
import java.util.Set;

public class sy2_t {

    public String getReimbursement(String read,String read2,String read3,String read4) {
        String type;
        int level;
        int times;
        int money;
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

    private void makeRes(String read,String read2,String read3,String read4) {
        System.out.println("请输入人员类别(在职,退休,老工人,退休劳模) ：" + read);
        System.out.println("请输入医院级别（1,2,3） ："+ read2);
        System.out.println("请输入报销次数 ："+ read3);
        System.out.println("请输入花费金额 ："+ read4);
        String res = getReimbursement(read, read2, read3, read4);
        if (res.equals("请重新输入！")){
            System.out.println("请重新输入！");
        }else {
            System.out.println("报销金额为: " +res);
        }
        System.out.println();
    }
    public static void main(String[] args) throws Exception {
        new sy2_t().makeRes("在职","1","1","300");
        new sy2_t().makeRes("在职","1","1","2000");
        new sy2_t().makeRes("在职","1","1","60000");
        new sy2_t().makeRes("在职","1","1","160000");

        new sy2_t().makeRes("在职","1","3","100");
        new sy2_t().makeRes("在职","1","3","300");
        new sy2_t().makeRes("在职","1","3","2000");
        new sy2_t().makeRes("在职","1","3","60000");
        new sy2_t().makeRes("在职","1","3","200000");

        new sy2_t().makeRes("在职","2","1","300");
        new sy2_t().makeRes("在职","2","1","2000");
        new sy2_t().makeRes("在职","2","1","60000");
        new sy2_t().makeRes("在职","2","1","160000");

        new sy2_t().makeRes("在职","2","3","100");
        new sy2_t().makeRes("在职","2","3","600");
        new sy2_t().makeRes("在职","2","3","2000");
        new sy2_t().makeRes("在职","2","3","60000");
        new sy2_t().makeRes("在职","2","3","200000");

        new sy2_t().makeRes("在职","3","1","300");
        new sy2_t().makeRes("在职","3","1","2000");
        new sy2_t().makeRes("在职","3","1","60000");
        new sy2_t().makeRes("在职","3","1","160000");

        new sy2_t().makeRes("在职","3","3","100");
        new sy2_t().makeRes("在职","3","3","600");
        new sy2_t().makeRes("在职","3","3","2000");
        new sy2_t().makeRes("在职","3","3","60000");
        new sy2_t().makeRes("在职","3","3","200000");

        new sy2_t().makeRes("退休","1","1","300");
        new sy2_t().makeRes("退休","1","1","2000");
        new sy2_t().makeRes("退休","1","1","60000");
        new sy2_t().makeRes("退休","1","1","160000");

        new sy2_t().makeRes("退休","3","3","100");
        new sy2_t().makeRes("退休","3","3","600");
        new sy2_t().makeRes("退休","3","3","2000");
        new sy2_t().makeRes("退休","3","3","60000");
        new sy2_t().makeRes("退休","3","3","200000");

        new sy2_t().makeRes("退休","2","1","300");
        new sy2_t().makeRes("退休","2","1","2000");
        new sy2_t().makeRes("退休","2","1","60000");
        new sy2_t().makeRes("退休","2","1","160000");

        new sy2_t().makeRes("退休","2","3","100");
        new sy2_t().makeRes("退休","2","3","600");
        new sy2_t().makeRes("退休","2","3","2000");
        new sy2_t().makeRes("退休","2","3","60000");
        new sy2_t().makeRes("退休","2","3","200000");

        new sy2_t().makeRes("退休","3","1","300");
        new sy2_t().makeRes("退休","3","1","2000");
        new sy2_t().makeRes("退休","3","1","60000");
        new sy2_t().makeRes("退休","3","1","160000");

        new sy2_t().makeRes("退休","3","3","100");
        new sy2_t().makeRes("退休","3","3","600");
        new sy2_t().makeRes("退休","3","3","2000");
        new sy2_t().makeRes("退休","3","3","60000");
        new sy2_t().makeRes("退休","3","3","200000");

        new sy2_t().makeRes("老工人","1","1","300");
        new sy2_t().makeRes("老工人","1","1","2000");
        new sy2_t().makeRes("老工人","1","1","60000");
        new sy2_t().makeRes("老工人","1","1","160000");

        new sy2_t().makeRes("老工人","1","3","100");
        new sy2_t().makeRes("老工人","1","3","300");
        new sy2_t().makeRes("老工人","1","3","2000");
        new sy2_t().makeRes("老工人","1","3","60000");
        new sy2_t().makeRes("老工人","1","3","200000");

        new sy2_t().makeRes("老工人","2","1","300");
        new sy2_t().makeRes("老工人","2","1","2000");
        new sy2_t().makeRes("老工人","2","1","60000");
        new sy2_t().makeRes("老工人","2","1","160000");

        new sy2_t().makeRes("老工人","2","3","100");
        new sy2_t().makeRes("老工人","2","3","600");
        new sy2_t().makeRes("老工人","2","3","2000");
        new sy2_t().makeRes("老工人","2","3","60000");
        new sy2_t().makeRes("老工人","2","3","200000");

        new sy2_t().makeRes("老工人","3","1","300");
        new sy2_t().makeRes("老工人","3","1","2000");
        new sy2_t().makeRes("老工人","3","1","60000");
        new sy2_t().makeRes("老工人","3","1","160000");

        new sy2_t().makeRes("老工人","3","3","100");
        new sy2_t().makeRes("老工人","3","3","600");
        new sy2_t().makeRes("老工人","3","3","2000");
        new sy2_t().makeRes("老工人","3","3","60000");
        new sy2_t().makeRes("老工人","3","3","200000");

        new sy2_t().makeRes("退休劳模","1","1","300");
        new sy2_t().makeRes("退休劳模","1","1","2000");
        new sy2_t().makeRes("退休劳模","1","1","60000");
        new sy2_t().makeRes("退休劳模","1","1","160000");

        new sy2_t().makeRes("退休劳模","1","3","100");
        new sy2_t().makeRes("退休劳模","1","3","300");
        new sy2_t().makeRes("退休劳模","1","3","2000");
        new sy2_t().makeRes("退休劳模","1","3","60000");
        new sy2_t().makeRes("退休劳模","1","3","200000");

        new sy2_t().makeRes("退休劳模","2","1","300");
        new sy2_t().makeRes("退休劳模","2","1","2000");
        new sy2_t().makeRes("退休劳模","2","1","60000");
        new sy2_t().makeRes("退休劳模","2","1","160000");

        new sy2_t().makeRes("退休劳模","2","3","100");
        new sy2_t().makeRes("退休劳模","2","3","600");
        new sy2_t().makeRes("退休劳模","2","3","2000");
        new sy2_t().makeRes("退休劳模","2","3","60000");
        new sy2_t().makeRes("退休劳模","2","3","200000");

        new sy2_t().makeRes("退休劳模","3","1","300");
        new sy2_t().makeRes("退休劳模","3","1","2000");
        new sy2_t().makeRes("退休劳模","3","1","60000");
        new sy2_t().makeRes("退休劳模","3","1","160000");

        new sy2_t().makeRes("退休劳模","3","3","100");
        new sy2_t().makeRes("退休劳模","3","3","600");
        new sy2_t().makeRes("退休劳模","3","3","2000");
        new sy2_t().makeRes("退休劳模","3","3","60000");
        new sy2_t().makeRes("退休劳模","3","3","200000");

        new sy2_t().makeRes("","3","1","300");
        new sy2_t().makeRes("退休劳模","","1","2000");
        new sy2_t().makeRes("退休劳模","3","","60000");
        new sy2_t().makeRes("退休劳模","3","1","");
        new sy2_t().makeRes("","3","1","");
        new sy2_t().makeRes("","","1","");
        new sy2_t().makeRes("","","","");

        new sy2_t().makeRes("教师","3","3","200000");
        new sy2_t().makeRes("退休劳模","5","3","200000");
        new sy2_t().makeRes("退休劳模","3","-3","200000");
        new sy2_t().makeRes("退休劳模","3","3","-200000");
        new sy2_t().makeRes("退休劳模","-3","-3","200000");
        new sy2_t().makeRes("教师","3","-3","-200000");
        new sy2_t().makeRes("工程师","-3","-3","-200000");
    }
}

