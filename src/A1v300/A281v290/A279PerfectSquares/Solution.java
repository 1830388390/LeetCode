package A1v300.A281v290.A279PerfectSquares;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public class NumSquares {
        private class Node {
            int val;
            int step;

            public Node(int val, int step) {
                this.val = val;
                this.step = step;
            }
        }

        public int numSquares(int n) {
            Queue<Node> res = new LinkedList<>();
            res.add(new Node(n, 1));
            boolean[] visited = new boolean[n + 1];
            while (!res.isEmpty()) {
                int val = res.peek().val;
                int stap = res.peek().step;
                res.remove();
                for (int i = 1; val - i * i >= 0; i++) {
                    int newVal = val - i * i;
                    if (newVal == 0) {
                        return stap;
                    } else if (!visited[newVal]) {
                        res.add(new Node(newVal, stap + 1));
                        visited[newVal] = true;
                    }
                }
            }
            return -1;
        }
    }
}