package LeetCode.weekCompetition;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class D15 {

    public int findSpecialInteger(int[] arr) {
        int limit = arr.length / 4;
        Map<Integer, Integer> times = new HashMap<>();
        for (int i : arr) {
            times.put(i, times.getOrDefault(i, 0) + 1);
            if (times.get(i) > limit) {
                return i;
            }
        }
        return 0;
    }


    public int removeCoveredIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals.length;
        }
        Arrays.sort(intervals, (int[] a, int[] b) -> {
            if (a[0] == b[0]) {
                return b[1] - a[1];
            } else {
                return a[0] - b[0];
            }
        });
        int second = intervals[0][1];
        int res = 1;
        for (int i = 1; i < intervals.length; i++) {
            if (second < intervals[i][1]) {
                res++;
                second = intervals[i][1];
            }
        }
        return res;
    }

//    class CombinationIterator {
//
//
//        public CombinationIterator(String characters, int combinationLength) {
//
//        }
//
//        public String next() {
//
//        }
//
//        public boolean hasNext() {
//
//        }
//    }
//
//    public int minFallingPathSum(int[][] arr) {
//
//    }
    /**
     * [
     * [1,2,3],
     * [4,5,6],
     * [7,8,9]
     * ]
     */
}
