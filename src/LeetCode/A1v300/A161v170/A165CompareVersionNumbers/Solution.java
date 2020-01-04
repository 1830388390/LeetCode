package LeetCode.A1v300.A161v170.A165CompareVersionNumbers;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int n = Math.max(v1.length, v2.length);
        for (int i = 0; i < n; i++) {
            int v1_int = i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int v2_int = i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if (v1_int == v2_int) {
                continue;
            }
            if (v1_int > v2_int) {
                return 1;
            } else {
                return -1;
            }
        }
        return 0;
    }
}
