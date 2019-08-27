package A51v60.A052NQueens;

class Solution {

    private int res = 0;

    public int totalNQueens(int n) {
        if (n == 0){
            return res;
        }
        boolean[] row = new boolean[n];
        boolean[] rightLine = new boolean[2*n];
        boolean[] leftLine = new boolean[2*n];
        makeRes(0,n,row,rightLine,leftLine);
        return res;
    }

    private void makeRes(int height, int length,
                         boolean[] row, boolean[] rightLine, boolean[] leftLine){
        if(height == length){
            res++;
        }
        for (int i = 0;i<=length - 1;i++){
            if (!row[i]&&!leftLine[height - i + length]&&!rightLine[height + i]){
                row[i] = true;
                leftLine[height - i + length] = true;
                rightLine[height + i] = true;
                makeRes(height + 1, length, row, rightLine, leftLine);
                row[i] = false;
                leftLine[height - i + length] = false;
                rightLine[height + i] = false;
            }else {
                continue;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().totalNQueens(4);
    }
}