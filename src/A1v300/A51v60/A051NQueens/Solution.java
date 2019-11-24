package A1v300.A51v60.A051NQueens;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {

    private List<List<String>> res = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        if (n == 0){
            return res;
        }
        boolean[] row = new boolean[n];
        boolean[] rightLine = new boolean[2*n];
        boolean[] leftLine = new boolean[2*n];
        makeRes(0,n,new Stack<>(),row,rightLine,leftLine);
        return res;
    }

    private void makeRes(int height, int length,Stack<String> str,
                         boolean[] row, boolean[] rightLine, boolean[] leftLine){
        if(height == length){
            res.add(new ArrayList<>(str));
        }
        for (int i = 0;i<=length - 1;i++){
            if (!row[i]&&!leftLine[height - i + length]&&!rightLine[height + i]){
                StringBuffer s = new StringBuffer();
                for (int k = 0;k<=length-1;k++){
                    s.append('.');
                }
                row[i] = true;
                leftLine[height - i + length] = true;
                rightLine[height + i] = true;
                s.replace(i,i+1,"Q");
                str.add(s.toString());
                makeRes(height + 1, length, str, row, rightLine, leftLine);
                str.pop();
                row[i] = false;
                leftLine[height - i + length] = false;
                rightLine[height + i] = false;
            }else {
                continue;
            }
        }
    }
}