package others;

import java.math.BigDecimal;
import java.util.*;


public class sy2_2_t {
    Map<Integer, People> peoples = new HashMap<>();

    class People {

        private String name;

        private String type;

        private int number;

        private int times;

        private double surplus;

        public People(String name, String type, int number) {
            this.number = number;
            this.name = name;
            this.type = type;
            this.times = 1;
            this.surplus = 150000.00;
        }

        public String getName() {
            return name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getTimes() {
            return times;
        }

        public double getSurplus() {
            return new BigDecimal(surplus).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }

        public boolean hasSurplus() {
            return surplus > 0.01;
        }

        public double doExpense(double expence) {
            Double MONEY_RANGE = 0.01;
            Double result = surplus - expence;
            Double res;
            if (surplus < MONEY_RANGE) {
                res = 0.00;
            } else if (result > MONEY_RANGE) {
                surplus = result;
                res = expence;
                times++;
            } else {
                res = surplus;
                surplus = 0.00;
                times++;
            }
            return new BigDecimal(res).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
        }
    }

    public String getReimbursement(String numberT, String nameT, String typeT, String levelT, String moneyT) {

        Set<String> types = new HashSet<>(4);
        types.add("在职");
        types.add("退休");
        types.add("老工人");
        types.add("退休劳模");
        String type, name;
        int level, times, number;
        double money;
        People people;
        String inputNumber = numberT;
        System.out.println("请输入人员编号 ：" + inputNumber);
        if ("".equals(inputNumber)) {
            return "请重新输入！";
        }
        number = Integer.valueOf(inputNumber);
        if (peoples.containsKey(number)) {
            people = peoples.get(number);
            String inputType = typeT;
            System.out.println("请修改人员类别(在职,退休,老工人,退休劳模),不输入则不修改 ：" + inputType);
            if (!"".equals(inputType) && types.contains(inputType) && !inputType.equals(people.getType())) {
                people.setType(inputType);
                peoples.put(number, people);
            }
            times = people.getTimes();
            name = people.getName();
            type = people.getType();
        } else {
            name = nameT;
            System.out.println("请输入人员姓名 ：" + name);
            if ("".equals(name)) {
                return "请重新输入！";
            }
            type = typeT;
            System.out.println("请输入人员类别(在职,退休,老工人,退休劳模) ：" + type);

            if (!"".equals(type) && types.contains(type)) {
                people = new People(name, type, number);
                peoples.put(number, people);
            } else {
                return "请重新输入！";
            }
            times = people.getTimes();
        }
        String inputLevel = levelT;
        System.out.println("请输入医院级别（1,2,3） ：" + inputLevel);
        if ("".equals(inputLevel) || Integer.valueOf(inputLevel) < 0 || Integer.valueOf(inputLevel) > 3) {
            return "请重新输入！";
        }
        level = Integer.valueOf(inputLevel);
        String inputMoney = moneyT;
        System.out.println("请输入花费金额 ：" + inputMoney);

        if ("".equals(name) || "".equals(inputMoney) || Double.valueOf(inputMoney) <= 0) {
            return "请重新输入！";
        }
        money = Double.valueOf(inputMoney);
        System.out.println("您之前共报销 " + times + " 次,剩余可报销金额为 " + people.getSurplus() + " 元!");
        if (!people.hasSurplus()) {
            return "0.00";
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
        int typeNum = "在职".equals(type) ? 1 :
                "退休".equals(type) ? 2 :
                        "老工人".equals(type) ? 3 :
                                "退休劳模".equals(type) ? 4 : 0;
        switch (typeNum) {
            case 1:
                if (money >= standard && money <= 55000) {
                    reimbursement = people.doExpense((money - standard) * 0.85);
                    break;
                }
                if (money > 55000 && money <= 150000) {
                    reimbursement = people.doExpense((55000 - standard) * 0.85 + (money - 55000) * 0.8);
                    break;
                }
                if (money > 150000) {
                    reimbursement = people.doExpense((150000 - 55000) * 0.8 + (55000 - standard) * 0.85);
                    break;
                }
                break;
            case 2:
                if (money >= standard && money <= 55000) {
                    reimbursement = people.doExpense((money - standard) * 0.9);
                    break;
                }
                if (money > 55000 && money <= 150000) {
                    reimbursement = people.doExpense((55000 - standard) * 0.9 + (money - 55000) * 0.8);
                    break;
                }
                if (money > 150000) {
                    reimbursement = people.doExpense((150000 - 55000) * 0.8 + (55000 - standard) * 0.9);
                    break;
                }
                break;
            case 3:
                if (money >= standard && money <= 55000) {
                    reimbursement = people.doExpense((money - standard) * 0.95);
                    break;
                }
                if (money > 55000 && money <= 150000) {
                    reimbursement = people.doExpense((55000 - standard) * 0.95 + (money - 55000) * 0.8);
                    break;
                }
                if (money > 150000) {
                    reimbursement = people.doExpense((150000 - 55000) * 0.8 + (55000 - standard) * 0.95);
                    break;
                }
                break;
            case 4:
                if (money >= standard && money <= 55000) {
                    reimbursement = people.doExpense((money - standard) * 0.95);
                    break;
                }
                if (money > 55000 && money <= 150000) {
                    reimbursement = people.doExpense((55000 - standard) * 0.95 + (money - 55000) * 0.8);
                    break;
                }
                if (money > 150000) {
                    reimbursement = people.doExpense((150000 - 55000) * 0.8 + (55000 - standard) * 0.95);
                    break;
                }
                break;
            default:
                break;
        }
        peoples.put(number, people);
        return "此次报销金额为 :" + String.format("%.2f", reimbursement);
    }

    private void run(String numberT, String nameT, String typeT, String levelT, String moneyT) {
        System.out.println(getReimbursement(numberT, nameT, typeT, levelT, moneyT));
        System.out.println();
    }

    private void clear(){
        this.peoples = new HashMap<>();
    }
    public static void main(String[] args) {
        sy2_2_t res = new sy2_2_t();
        res.run("1","李彦龙","在职","1","200");
        res.run("2","王琳","在职","1","2000");
        res.run("3","张子辰","在职","1","60000");
        res.run("4","刘莉莉","在职","1","200000");
        res.run("1","","","1","200");
        res.run("1","","","1","200");
        res.run("2","","","1","2000");
        res.run("3","","","1","60000");
        res.run("4","","","1","200000");
        res.clear();
        res.run("1","李彦龙","在职","2","200");
        res.run("2","王琳","在职","2","2000");
        res.run("3","张子辰","在职","2","60000");
        res.run("4","刘莉莉","在职","2","200000");
        res.run("1","","","2","200");
        res.run("2","","","2","2000");
        res.run("3","","","2","60000");
        res.run("4","","","2","200000");
        res.clear();
    }

}

