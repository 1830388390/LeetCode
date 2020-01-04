package LeetCode.A501v2000.A1253Reconstructa2RowBinaryMatrix;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> reconstructMatrix(int upper, int lower, int[] colsum) {
        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i : colsum){
            switch (i){
                case 0:
                    up.add(0);
                    down.add(0);
                    continue;
                case 1:
                    if (upper>lower){
                        upper--;
                        up.add(1);
                        down.add(0);
                    }else {
                        lower--;
                        down.add(1);
                        up.add(0);
                    }
                    if (upper <0 || lower<0){
                        return res;
                    }
                    continue;
                case 2:
                    upper--;
                    lower--;
                    up.add(1);
                    down.add(1);
                    if (upper <0 || lower<0){
                        return res;
                    }
                    continue;
                 default:
                     break;
            }
        }
        if (upper >0 || lower>0){
            return res;
        }
        res.add(up);
        res.add(down);
        return res;
    }
}