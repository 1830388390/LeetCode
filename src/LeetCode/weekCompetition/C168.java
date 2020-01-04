package LeetCode.weekCompetition;


import java.util.*;

public class C168 {

    public boolean isPossibleDivide(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        Arrays.sort(nums);
        for (int i : nums) {
            if (!map.containsKey(i) || map.get(i) == 0) {
                continue;
            }
            for (int j = 0; j < k; j++) {
                if (!map.containsKey(i + j)) {
                    return false;
                }
                int times = map.get(i + j);
                if (times - 1 < 0) {
                    return false;
                } else {
                    map.put(i + j, times - 1);
                }
            }
        }
        return true;
    }

    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {

        long startTime = System.currentTimeMillis();   //获取开始时间
        Map<String, Integer> strs = new HashMap<>();
        int time = 0;
        for (int i = 0; i < s.length() - minSize + 1; i++) {
            String str = s.substring(i, i + minSize);
            System.out.println(str);
            Set<Character> characters = new HashSet<>();
            for (char c : str.toCharArray()) {
                characters.add(c);
            }
            if (characters.size() <= maxLetters) {
                strs.put(str, strs.getOrDefault(str, 0) + 1);
                time = Integer.max(time, strs.get(str));
            }
        }

        long endTime = System.currentTimeMillis(); //获取结束时间

        System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
        return time;
    }


    /**
     * "aababcaab"
     * 2
     * 3
     * 4
     *
     * @param args
     */
    public static void main(String[] args) {

        new C168().maxFreq("aababcaab", 2, 3, 4);
    }

    boolean[] isPass; // 可到达的箱子
    boolean[] isAdd;
    int[] status;
    int[] candies;
    int[][] keys;
    int[][] containedBoxes;
    int sum = 0;

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        isPass = new boolean[status.length];
        isAdd = new boolean[status.length];
        this.status = status;
        this.candies = candies;
        this.keys = keys;
        this.containedBoxes = containedBoxes;
        for (int i : initialBoxes) {
            isPass[i] = true;
            DFS(i);
        }
        return sum;
    }

    private void DFS(int cur) {
        /**
         * 只有有钥匙并且能到达的箱子才能添加,
         * 添加过了的箱子不再遍历
         */
        if (status[cur] == 1 && !isAdd[cur] && isPass[cur]) {
            sum += candies[cur];
            isAdd[cur] = true;
        } else {
            return;
        }
        /**
         * 所有有钥匙和能到达的箱子
         */
        Set<Integer> box = new HashSet<>();
        /**
         * 开启对应有钥匙的箱子
         */
        for (int k : keys[cur]) {
            status[k] = 1;
            box.add(k);
        }
        /**
         * 记录能到达的箱子
         */
        for (int c : containedBoxes[cur]) {
            isPass[c] = true;
            box.add(c);
        }

        for (int cu : box){
            DFS(cu);
        }
    }

}
