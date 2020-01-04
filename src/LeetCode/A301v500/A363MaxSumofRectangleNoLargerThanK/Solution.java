package LeetCode.A301v500.A363MaxSumofRectangleNoLargerThanK;

class Solution {
    public int maxSumSubmatrix(int[][] matrix, int k) {
        int height = matrix.length;
        int width = matrix[0].length;
        int[][] tmp = new int[height + 1][width + 1];
        int res = -Integer.MAX_VALUE;
        for (int y1 = 1; y1 <= height; y1++) {
            for (int x1 = 1; x1 <= width; x1++) {
                tmp[y1][x1] = tmp[y1 - 1][x1] + tmp[y1][x1 - 1]
                            + matrix[y1 - 1][x1 - 1] - tmp[y1 - 1][x1 - 1];
            }
        }
        for (int y1 = 1;y1<=height;y1++){
            for (int x1 = 1;x1<=width;x1++){

                for (int y2 = y1;y2<=height;y2++){
                    for (int x2 = x1;x2<=width;x2++){
                        int area = getArea(tmp,y1,x1,y2,x2);
                        if (area > res && area<=k){
                            res = area;
                        }
                    }
                }

            }
        }
        return res;
    }

    private int getArea(int[][] tmp,int y1,int x1,int y2,int x2){
        return tmp[y2][x2] + tmp[y1 - 1][x1 - 1] - tmp[y1 - 1][x2] - tmp[y2][x1 - 1];
    }
}