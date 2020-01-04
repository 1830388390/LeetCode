package LeetCode.A1v300.A111v120.A118PascalTriangle;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if (numRows == 0) {
            return res;
        }

        List<Integer> re = new ArrayList<>();
        re.add(1);
        res.add(re);
        if (numRows == 1) {
            return res;
        }
        for (int i = 1; i <= numRows - 1; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0){
                    List<Integer> r = new ArrayList<>();
                    r.add(1);
                    res.add(r);
                }else if (j == i){
                    res.get(i).add(1);
                }else {
                    int n = res.get(i - 1).get(j) + res.get(i - 1).get(j - 1);
                    res.get(i).add(n);
                }
            }
        }
        return res;
    }
}