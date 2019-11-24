package weekCompetition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C159 {
    class Solution {
        public boolean checkStraightLine(int[][] coordinates) {
            if (coordinates.length <= 2) {
                return false;
            }
            int x1 = coordinates[0][0];
            int x2 = coordinates[1][0];
            int y1 = coordinates[0][1];
            int y2 = coordinates[1][1];
            double k1 = (double) (y2 - y1) / (x2 - x1);
            for (int i = 2; i < coordinates.length - 1; i++) {
                int x3 = coordinates[i][0];
                int y3 = coordinates[i][1];
                double k2 = (double) (y3 - y1) / (x3 - x1);
                if (k2 != k1) {
                    return false;
                }

            }
            return true;
        }
    }


    class Solution2 {
        public List<String> removeSubfolders(String[] folder) {
            int i = 1;
            Arrays.sort(folder);
            String s = folder[0];
            ArrayList<String> res = new ArrayList<>();
            while (i < folder.length) {
                String ts = folder[i];
                if (ts.startsWith(s) && ts.charAt(s.length()) == '/') {
                    i++;
                } else {
                    res.add(s);
                    s = folder[i];
                    i++;
                }
            }
            res.add(s);
            return res;
        }
    }


    class Solution3 {
        public int balancedString(String s) {
            int Q = 0, W = 0, E = 0, R = 0;
            for (int i = 0; i < s.length(); i++) {
                char K = s.charAt(i);
                if (K == 'Q') Q++;
                if (K == 'W') W++;
                if (K == 'E') E++;
                if (K == 'R') R++;
            }
            int k = s.length() / 4;
            int res = Math.abs(Q - k) + Math.abs(W - k) + Math.abs(E - k) + Math.abs(R - k);
            return res/2;
        }
    }
}
