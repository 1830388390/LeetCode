package LeetCode.A501v2000.A1252CellswithOddValuesinaMatrix;

class Solution {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] res = new int[n][m];
        for (int[] tmp : indices){
            int y = tmp[0];
            int x = tmp[1];
            for (int i = 0;i<m;i++){
                res[y][i]++;
            }
            for (int j = 0;j<n;j++){
                res[j][x]++;
            }
        }
        int k = 0;
        for (int i = 0;i<n;i++){
            for (int j = 0;j<m;j++){
                if (res[i][j]%2 == 1){
                    k++;
                }
            }
        }
        return k;
    }
}