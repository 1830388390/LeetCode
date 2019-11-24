package A501v2000.A847ShortestPathVisitingAllNodes;

import javafx.util.Pair;

import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int shortestPathLength(int[][] graph) {
        int length = graph.length;
        if (length == 0) {
            return 0;
        }
        boolean[][] visited = new boolean[length][1 << length];
        int finish = (1 << length) - 1; //1000000 - 1 = 0111111
        Queue<Pair<Integer, Integer>> BFS = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            BFS.offer(new Pair<>(i, 1 << i));
        }
        int step = 0;
        while (!BFS.isEmpty()) {
            for (int i = BFS.size(); i >0; i--) {
                Pair<Integer, Integer> node = BFS.poll();
                if (node.getValue() == finish) {
                    return step;
                }
                for (int next : graph[node.getKey()]) {
                    int newPath = node.getValue() | (1 << next);
                    if (visited[next][newPath]) {
                        continue;
                    } else {
                        visited[next][newPath] = true;
                        BFS.offer(new Pair<>(next, newPath));
                    }
                }
            }
            step++;
        }
        return step;
    }
}