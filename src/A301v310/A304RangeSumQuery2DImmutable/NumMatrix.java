package A301v310.A304RangeSumQuery2DImmutable;

class NumMatrix {
    int[][] sum;

    public NumMatrix(int[][] matrix) {
        int height = matrix.length;
        if (height == 0){
            return;
        }
        int wide = matrix[0].length;
        if (wide == 0){
            return;
        }
        this.sum = new int[height][wide];
        sum[0][0] = matrix[0][0];
        for (int i = 1; i < height; i++) {
            sum[i][0] = sum[i - 1][0] + matrix[i][0];
        }
        for (int i = 1; i < wide; i++) {
            sum[0][i] = sum[0][i - 1] + matrix[0][i];
        }
        int x = 1;
        int y = 1;
        while (y < height && x < wide) {
            sum[y][x] = sum[y - 1][x] + sum[y][x - 1] - sum[y - 1][x - 1] + matrix[y][x];
            x++;
            if (x == wide) {
                x = 1;
                y++;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {

        /**
         *   [a3, 0, 1, 4, a1],
         *   [5, 6, 3, 2, 1],
         *   [1, 2, 0, 1, 5],
         *   [4, 1, 0, 1, 7],
         *   [a2, 0, 3, 0, a4]
         *
         */
        int area1 = row1 - 1 < 0 ? 0 : sum[row1 - 1][col2];
        int area2 = col1 - 1 < 0 ? 0 : sum[row2][col1 - 1];
        int area3 = 0;
        if (row1 - 1 >=0 && col1 - 1 >=0){
            area3 = sum[row1 - 1][col1 - 1];
        }
        int area4 = sum[row2][col2];
        return area4 - area1 - area2 + area3;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */