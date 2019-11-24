package A1v300.A81v90.A085MaximalRectangle;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        int height = matrix.length;
        if (height == 0) {
            return 0;
        }
        int width = matrix[0].length;
        if (width == 0) {
            return 0;
        }
        int[][] heights = new int[height][width];
        for (int i = 0; i < width; i++) {
            if (matrix[0][i] == '1') {
                heights[0][i] = 1;
            }
        }
        int y = 1;
        int x = 0;
        while (x < width && y < height) {
            if (matrix[y][x] == '1'){
                heights[y][x] = heights[y - 1][x] + 1;
            }
            y++;
            if (y == height){
                y = 1;
                x++;
            }
        }
        y = 0;
        x = 0;
        int area = 0;
        while (x < width && y < height){
            if (heights[y][x] > 0){
                int h = heights[y][x];
                int tmpArea = h;
                int left = x - 1;
                int right = x + 1;
                while (left>=0){
                    if (heights[y][left] >= h){
                        tmpArea = tmpArea + h;
                        left --;
                    }else {
                        break;
                    }
                }
                while (right<=width - 1){
                    if (heights[y][right] >= h){
                        tmpArea = tmpArea + h;
                        right++;
                    }else {
                        break;
                    }
                }
                area = Integer.max(tmpArea,area);
            }
            x++;
            if (x == width){
                x =0;
                y++;
            }
        }
        return area;
    }

    public static void main(String[] args) {
        new Solution().maximalRectangle(new  char[][]{{'0'},{'1'}} );
    }
}