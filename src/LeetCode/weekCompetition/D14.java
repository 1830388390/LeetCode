package LeetCode.weekCompetition;

import java.util.*;

public class D14 {
    public String toHexspeak(String num) {
        StringBuffer res = new StringBuffer();
        Long N = Long.valueOf(num);
        String[] words = new String[]{"O", "I", "X", "X", "X", "X", "X", "X", "X", "X", "A", "B", "C", "D", "E", "F"};
        while (N > 0) {
            long y = N % 16;
            N /= 16;
            String s = words[(int) y];
            if ("X".equals(s)) {
                return "ERROR";
            }
            res.append(s);
        }
        return res.reverse().toString();
    }

    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        boolean addF = false;
        boolean addS = false;
        for (int[] tmp : intervals) {
            List<Integer> re = new ArrayList<>();
            if (tmp[1] < toBeRemoved[0] || tmp[0] > toBeRemoved[1]) {
                re.add(tmp[0]);
                re.add(tmp[1]);
                res.add(re);
                continue;
            }
            if (tmp[0] >= toBeRemoved[0] && tmp[1] >= toBeRemoved[1]) {
                re.add(toBeRemoved[1]);
                re.add(tmp[1]);
                res.add(re);
                continue;
            }
            if (tmp[0] <= toBeRemoved[0] && tmp[1] <= toBeRemoved[1]) {
                re.add(tmp[0]);
                re.add(toBeRemoved[0]);
                res.add(re);
                continue;
            }
            if (tmp[0] < toBeRemoved[0] && tmp[1] > toBeRemoved[1]) {
                re.add(tmp[0]);
                re.add(toBeRemoved[0]);
                res.add(re);
                List<Integer> r = new ArrayList<>();
                r.add(toBeRemoved[1]);
                r.add(tmp[1]);
                res.add(re);
            }
        }
        return res;
    }


    List<Set<Integer>> childs;
    int[] value;

    public int deleteTreeNodes(int nodes, int[] parent, int[] value) {
        this.value = value;
        childs = new ArrayList<>(nodes);
        for (int i = 0; i < nodes; i++) {
            childs.add(new HashSet<>());
        }

        /**
         * 转换为孩子表示法
         */
        for (int i = 1; i < nodes; i++) {
            childs.get(parent[i]).add(i);
        }

        /**
         * 整棵树和为0,直接返回0
         */
        if (DFS(0) == 0) {
            return 0;
        }

        /**
         * 广度遍历所有存在的节点
         */
        Queue<Integer> BFS = new LinkedList<>();
        BFS.add(0);
        int res = 0;
        while (!BFS.isEmpty()) {
            int v = BFS.remove();
            for (int n : childs.get(v)) {
                BFS.add(n);
            }
            res++;
        }
        return res;
    }

    private int DFS(int num) {
        int res = value[num];
        List<Integer> delete = new ArrayList<>();
        for (int child : childs.get(num)) {
            int v = DFS(child);
            /**
             * 如果下个节点和为0,直接将下个节点删除,下个节点的孩子节点不用删除,
             * 因为是无环图,所以删除父节点,孩子节点就无法被访问
             */
            if (v == 0) {
                delete.add(child);
            }
            res += v;
        }

        for (int i : delete) {
            childs.get(num).remove(i);
        }
        return res;
    }


    class Sea {
        public boolean hasShips(int[] topRight, int[] bottomLeft) {
            return false;
        }
    }

    public int countShips(Sea sea, int[] topRight, int[] bottomLeft) {
        return 0;
    }
}
