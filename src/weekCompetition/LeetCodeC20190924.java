package weekCompetition;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.*;

public class LeetCodeC20190924 {
    class Solution {
        public int game(int[] guess, int[] answer) {
            int length1 = guess.length;
            int length2 = answer.length;
            if (length1 == 0 || length2 == 0) {
                return 0;
            }
            int res = 0;
            for (int i = 0; i < length1 && i < length2; i++) {
                if (guess[i] == answer[i]) {
                    res++;
                }
            }
            return res;
        }
    }

    class Solution2 {
        public int[] fraction(int[] cont) {
            int numerator = cont[cont.length - 1];
            int denominator = 1;
            for (int i = cont.length - 2; i >= 0; i--) {
                int tmp = numerator;
                numerator = denominator;
                denominator = tmp;
                numerator = cont[i] * denominator + numerator;
            }

            int gcd =gcd(Math.abs(numerator),Math.abs(denominator));
            if (numerator<0&&denominator<0){
                numerator = -numerator;
                denominator = -denominator;
            }
            return new int[]{numerator/gcd, denominator/gcd};
        }

        public int gcd(int x, int y){ // 这个是运用辗转相除法求 两个数的 最大公约数 看不懂可以百度 // 下
            if(y == 0) {
                return x;
            } else {
                return gcd(y,x%y);
            }
        }
    }

    class Solution3 {
        public boolean robot(String command, int[][] obstacles, int x, int y) {
            int h = 0;
            int w = 0;
            boolean[][] isUsed = new boolean[y + 1][x + 1];
            for (int[]tmp : obstacles ){
                if (tmp[0]<=y && tmp[1]<=x){
                    isUsed[tmp[0]][tmp[1]] = true;
                }
            }
            while (h != y || x != w) {
                if (h > y && w > x) {
                    return false;
                }
                for (int i = 0; i < command.length(); i++) {
                    if (command.charAt(i) == 'U') {
                        h++;
                        if (h == y && w == x) {
                            return true;
                        }
                        if (isUsed[h][w]) {
                            return false;
                        }
                        continue;
                    }

                    if (command.charAt(i) == 'R') {
                        w++;
                        if (h == y && w == x) {
                            return true;
                        }
                        if (isUsed[h][w]) {
                            return false;
                        }
                        continue;
                    }
                }
            }
            return true;
        }
    }

    static class Solution4 {
        int res = 0;
        boolean[][] isUsed;
        int height;
        int width;

        public int domino(int n, int m, int[][] broken) {
            this.height = n;
            this.width = m;
            if (width == height && height == 1 || width == 0 || height == 0) {
                return 0;
            }
            this.isUsed = new boolean[height][width];
            for (int[] tmp : broken) {
                int y = tmp[0];
                int x = tmp[1];
                isUsed[y][x] = true;
            }
            makeRes(0, 0, 0);
            return res;
        }

        private void makeRes(int y, int x, int tmpRes) {
            if (y >= height) {
                return;
            }
            if (x >= width) {
                x = 0;
                y++;
                makeRes(y, x, tmpRes);
                return;
            }
            if (isUsed[y][x]) {
                x++;
                if (x == width) {
                    x = 0;
                    y++;
                }
                makeRes(y, x, tmpRes);
                return;
            }
            if (x + 1 < width) {
                if (!isUsed[y][x + 1]) {
                    isUsed[y][x] = true;
                    isUsed[y][x + 1] = true;
                    int tmpx = x + 1;
                    int tmpy = y;
                    if (tmpx == width) {
                        tmpx = 0;
                        tmpy++;
                    }
                    res = Integer.max(res, tmpRes + 1);
                    makeRes(tmpy, tmpx, tmpRes + 1);
                    isUsed[y][x] = false;
                    isUsed[y][x + 1] = false;
                }
            }
            if (y + 1 <height){
                if (y + 1 < height && !isUsed[y + 1][x]) {
                    isUsed[y][x] = true;
                    isUsed[y + 1][x] = true;
                    int tmpx = x + 1;
                    int tmpy = y;
                    if (tmpx == width) {
                        tmpx = 0;
                        tmpy++;
                    }
                    res = Integer.max(res, tmpRes + 1);
                    makeRes(tmpy, tmpx, tmpRes + 1);
                    isUsed[y][x] = false;
                    isUsed[y + 1][x] = false;
                }
            }
        }
    }


    class Solution5 {
        class Node{
            int val;
            Node leader;
            Set<Node> employees;
            long money = 0;
            long sumMoney = 0;
            Node(int val,Node leader){
                this.val = val;
                this.leader = leader;
                this.employees = new HashSet<>();
            }
        }
        public int[] bonus(int n, int[][] leadership, int[][] operations) {
            List<Integer> res = new ArrayList<>();
            Map<Integer,Node> map = new HashMap<>();
            for (int i = 1;i<=n;i++){
                map.put(i,new Node(i,null));
            }
            for (int[]ems : leadership){
                Node leader = map.get(ems[0]);
                Node employee = map.get(ems[1]);
                employee.leader = leader;
                leader.employees.add(employee);
            }
            for (int[] o : operations){
                switch (o[0]){
                    case 1:
                        Node em = map.get(o[1]);
                        em.money = em.money + o[2];
                        Node leader = em.leader;
                        while (leader!=null){
                            leader.sumMoney = leader.sumMoney + o[2];
                            leader = leader.leader;
                        }
                        break;
                    case 2:
                        Node em2 = map.get(o[1]);
                        long tmp = em2.sumMoney;
                        addMoney(em2,o[2]);
                        long addmoney = em2.sumMoney - tmp + o[2];
                        Node leader2 = em2.leader;
                        while (leader2!=null){
                            leader2.sumMoney = leader2.sumMoney + addmoney;
                            leader2 = leader2.leader;
                        }
                        break;
                    case 3:
                        for (Node ns : map.values()){
                            System.out.println(ns.money);
                        }
                        Node em3 = map.get(o[1]);
                        long sum = em3.money + em3.sumMoney;
                        res.add((int) (sum%(1000000007)));
                        break;
                }
            }
            int[] re = new int[res.size()];
            for (int i = 0;i<res.size();i++){
                re[i] = res.get(i);
            }
            return re;
        }

        private long addMoney(Node em,long addM){

            em.money = em.money + addM;
            System.out.println(em.val + " " + em.sumMoney);
            if (em.employees.size() == 0){
                return addM;
            }
            for (Node e : em.employees){
                em.sumMoney = em.sumMoney + addMoney(e,addM);
            }
            return em.employees.size()*addM;
        }
    }

    public static void main(String[] args) {
        new Solution4().domino(2, 3, new int[][]{});
    }
}
