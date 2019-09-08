package A51v60.A057InsertInterval;


import java.util.ArrayList;

class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        ArrayList<int[]> res = new ArrayList<>();
        int l = intervals.length;
        if (intervals.length == 0 || intervals == null){
            res.add(newInterval);
            return res.toArray(new int[0][]);
        }
        int leftTarget = newInterval[0];
        int rightTarget = newInterval[1];
        int i = 0;
        while (i <= l-1){
            if (rightTarget < intervals[i][0]){
                res.add(new int[]{leftTarget,rightTarget});
                res.add(intervals[i]);
                if (i == l-1) {
                    break;
                }else {
                    i++;
                    while (i <= l-1){
                        res.add(intervals[i]);
                        i++;
                    }
                    break;
                }
            }
            if (leftTarget > intervals[i][1]){
                res.add(intervals[i]);
                if (i==l-1){
                    res.add(new int[]{leftTarget,rightTarget});
                    break;
                }else {
                    i++;
                    continue;
                }
            }
            if (leftTarget <= intervals[i][1] || rightTarget >= intervals[i][0] ){
                rightTarget = Math.max(rightTarget,intervals[i][1]);
                leftTarget = Math.min(leftTarget,intervals[i][0]);
                if (i == l - 1){
                    res.add(new int[]{leftTarget,rightTarget});
                    break;
                }else {
                    i++;
                    continue;
                }

            }
        }
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        new Solution().insert(new int[][]{{1,3},{6,9}},new int[]{2,5});
    }
}