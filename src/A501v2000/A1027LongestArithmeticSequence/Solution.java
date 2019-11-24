package A501v2000.A1027LongestArithmeticSequence;

import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int videoStitching(int[][] clips, int T) {
        int res = 0;
        int e = 0;
        int index = 0;
        Arrays.sort(clips, Comparator.comparingInt(a -> a[0]));
        while (e < T) {
            int tmp = e;
            int[] l = getLongest(e,index, clips);
            e = l[0];
            index = l[1];
            if (tmp == e) {
                return -1;
            }
            ++res;
        }
        return res;
    }

    /**
     * 贪心
     * @param s
     * @param clips
     * @return
     */
    private int[] getLongest(int s, int index,int[][] clips) {
        int maxEnd = 0;
        for (int i = index;i<clips.length;i++) {
            int start = clips[i][0];
            int end = clips[i][1];
            if (start <= s && end >= s) {
                maxEnd = Math.max(maxEnd, end);
                if (maxEnd == end){
                    index = i;
                }
            }
        }
        return new int[]{maxEnd,index};
    }
}