package A201v210.A210CourseScheduleII;

import java.util.Arrays;
import java.util.Stack;

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        if (numCourses <=0){
            return new int[]{};
        }
        int[] penetration = new int[numCourses];
        Stack<Integer> res = new Stack<>();
        Stack<Integer> topology = new Stack<>();
        for (int[] tmp : prerequisites) {
            penetration[tmp[0]]++;
        }
        int i = 0;
        for (int tmp : penetration) {
            if (tmp == 0) {
                topology.push(i);
            }
            i++;
        }
        while (!topology.isEmpty()) {
            int node = topology.pop();
            res.add(node);
            numCourses--;
            for (int[] tmp : prerequisites) {
                if (tmp[1] == node  && --penetration[tmp[0]] == 0) {
                    topology.add(tmp[0]);
                }
            }
        }
        int j = res.size();
        int[] r = new int[j];
        j--;
        while (!res.isEmpty()){
            r[j] = res.pop();
            j--;
        }
        return numCourses == 0 ? r : new int[]{};
    }

    public static void main(String[] args) {
        new Solution().findOrder(3,new int[][]{{1,0},{1,2},{0,2}});
    }
}