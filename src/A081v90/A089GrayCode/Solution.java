package A081v90.A089GrayCode;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> ret = new ArrayList<>();
        for(int i = 0; i < 1<<n; ++i) {
            ret.add(i ^ i>>1);
        }
        return ret;
    }
}