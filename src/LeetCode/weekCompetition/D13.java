package LeetCode.weekCompetition;

import java.util.*;

public class D13 {


    public String encode(int num) {
        return Integer.toBinaryString(num + 1).substring(1);
    }

    public String findSmallestRegion(List<List<String>> regions, String region1, String region2) {
        class Node {
            String region;
            Node pre;

            public Node(String region, Node pre) {
                this.region = region;
                this.pre = pre;
            }
        }
        Map<String, Node> regionsMap = new HashMap<>();
        for (List<String> tmp : regions) {
            String r1 = tmp.get(0);
            Node n1;
            if (regionsMap.containsKey(r1)) {
                n1 = regionsMap.get(r1);
            } else {
                n1 = new Node(r1, null);
                regionsMap.put(r1, n1);
            }
            for (int i = 1; i < tmp.size(); i++) {
                Node node;
                if (!regionsMap.containsKey(tmp.get(i))) {
                    node = new Node(tmp.get(i), n1);
                    regionsMap.put(tmp.get(i), node);
                }
            }


        }
        Node r1 = regionsMap.get(region1);
        Node r2 = regionsMap.get(region2);
        Node t1 = r1;
        Node t2 = r2;
        while (t1 != t2) {
            t1 = t1 == null ? r2 : t1.pre;
            t2 = t2 == null ? r1 : t2.pre;
        }
        return t1.region;
    }

    public List<String> generateSentences(List<List<String>> synonyms, String text) {
        Map<String, ArrayList<String>> words = new HashMap<>();
        for (List<String> tmp : synonyms) {
            if (words.containsKey(tmp.get(0))) {
                ArrayList<String> list = words.get(tmp.get(0));
                list.add(tmp.get(1));
                words.remove(tmp.get(0));
                words.put(tmp.get(1), list);
            } else {
                words.put(tmp.get(0), (ArrayList<String>) Arrays.asList(tmp.get(1)));
            }
        }
        return null;
    }

    public int numberOfWays(int num_people) {
        int half = num_people / 2;
        long sum = 1;
        int mod = 1000000007;
        for (int i = num_people; i > half; i--) {
            sum *= i;
            sum %= mod;
        }
        long d = 1;
        for (int i = 1; i <= half; i++) {
            d *= i;
            d %= mod;
        }
        sum /= d;
        sum = sum / (half + 1);
        sum %= mod;
        return (int) sum;
    }

    public static void main(String[] args) {
        new D13().numberOfWays(30);
    }
}
