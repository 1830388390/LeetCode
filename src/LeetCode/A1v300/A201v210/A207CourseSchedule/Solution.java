package LeetCode.A1v300.A201v210.A207CourseSchedule;

import java.util.Stack;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses == 0){
            return false;
        }
        int[] penetration = new int[numCourses];
        for (int[] tmp : prerequisites){
            penetration[tmp[0]] ++;
        }
        Stack<Integer> topologicalSort = new Stack<>();
        int i = 0;
        for (int tmp : penetration){
            if (tmp == 0){
                topologicalSort.push(i);
            }
            i++;
        }

        while (!topologicalSort.isEmpty()){
            int out = topologicalSort.pop();
            numCourses --;
            for (int[] tmp : prerequisites){
                if (tmp[1] == out && --penetration[tmp[0]] == 0){
                    topologicalSort.push(tmp[0]);
                }
            }
        }
        System.out.println(numCourses);
        return numCourses == 0;
    }

    public static void main(String[] args) {
        new Solution().canFinish(3,new int[][]{{1,0},{1,2},{0,2}});
    }
}