package LeetCode.weekCompetition;

import java.util.*;

public class C164 {

    public int minTimeToVisitAllPoints(int[][] points) {
        int sum = 0;
        if (points.length <= 1) {
            return sum;
        }
        int[] num = points[0];
        for (int i = 1; i < points.length; i++) {
            sum += Integer.max(Math.abs(num[0] - points[i][0]), Math.abs(num[1] - points[i][1]));
            num = points[i];
        }
        return sum;
    }


    public int countServers(int[][] grid) {
        int height = grid.length;
        int wide = grid[0].length;
        int sum = 0;
        int[] col = new int[wide];
        int[] row = new int[height];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < wide; x++) {
                if (grid[y][x] == 1) {
                    col[x]++;
                    row[y]++;
                    sum++;
                }
            }
        }
        for (int i = 0; i < height; i++) {
            if (row[i] == 1) {
                for (int j = 0; j < wide; j++) {
                    if (grid[i][j] == 1) {
                        if (col[j] == 1) {
                            sum--;
                        }
                        break;
                    }
                }
            }
        }
        return sum;
    }

    class Node {
        List<String> words;
        Map<Character, Node> nodes;

        Node() {
            this.words = new ArrayList<>();
            this.nodes = new HashMap<>(26);
        }
    }

    /**
     * 这里为了加快寻找速度,记忆上一个节点,将node设置为全局变量
     */
    Node node;

    private void makeTree(String[] products, Node node) {
        for (String s : products) {
            Node tmp = node;
            for (char c : s.toCharArray()) {
                if (!tmp.nodes.containsKey(c)) {
                    Node newNode = new Node();
                    newNode.words.add(s);
                    tmp.nodes.put(c, newNode);
                } else {
                    tmp.nodes.get(c).words.add(s);
                }
                tmp = tmp.nodes.get(c);
            }
        }
    }

    private List<String> getStr(char c) {
        List<String> res = new ArrayList<>();
        if (node == null || !node.nodes.containsKey(c)) {
            node = null;
            return new ArrayList<>();
        } else {
            node = node.nodes.get(c);
            res = node.words;
        }
        if (res.size() > 3) {
            res = res.subList(0, 3);
        }
        return res;
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        node = new Node();
        /**
         * 由于List数组有序,所以先排序,每次makeTree操作不用排序
         */
        Arrays.sort(products);
        makeTree(products, node);
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < searchWord.length(); i++) {
            res.add(getStr(searchWord.charAt(i)));
        }
        return res;
    }

    public int numWays(int steps, int arrLen) {
        if (steps <= 0 || arrLen <= 0) {
            return 0;
        }
        if (steps == 1 || arrLen == 1) {
            return 1;
        }
        int mod = 1000000007; // 1 + 8个0 + 7
        int[][] res = new int[steps][steps+1];
        res[0][0] = 1;
        res[0][1] = 1;
        for (int i = 1; i < steps; i++) {
            for (int j = 0; j < steps+1 && j<arrLen; j++) {
                if (j - 1 >= 0) {
                    res[i][j] += res[i - 1][j - 1];
                    res[i][j] %= mod;
                }
                if (j + 1 < steps+1) {
                    res[i][j] += res[i - 1][j + 1];
                    res[i][j] %= mod;
                }
                res[i][j] += res[i - 1][j];
                res[i][j] %= mod;
            }
        }

        return res[steps - 1][0];
    }

    public static void main(String[] args) {
        new C164().numWays(5,3);
    }
}
