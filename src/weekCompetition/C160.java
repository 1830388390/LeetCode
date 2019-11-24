package weekCompetition;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class C160 {

    /*
     * // This is the custom function interface.
     * // You should not implement it, or speculate about its implementation
     */

    class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return 1;
        }
    }

    class Solution {
        public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
            List<List<Integer>> res = new ArrayList<>();
            for (int x = 1; x <= 1000; x++) {
                for (int y = 1; y <= 1000; y++) {
                    int a = customfunction.f(x, y);
                    if (a > z) {
                        break;
                    }
                    if (a == z) {
                        res.add(Arrays.asList(x, y));
                        break;
                    }
                }
            }
            return res;
        }
    }

    class Solution2 {
        public List<Integer> circularPermutation(int n, int start) {
            List<Integer> tmp = new ArrayList<>();

            for (int i = 0; i < 1 << n; i++) {
                tmp.add(i ^ i >> 1);
            }
            int s = tmp.indexOf(start);
            List<Integer> res = new ArrayList<>(tmp.size());
            for (int i = s;i<tmp.size();i++){
                res.add(tmp.get(i));
            }
            for (int i = 0;i<s;i++){
                res.add(tmp.get(i));
            }
            return res;
        }
    }

    static class Solution3 {
        int res;
        List<String> arr;
        public int maxLength(List<String> arr) {
            this.res = 0;
            this.arr = arr;
            makeRes(0,new boolean[26],0);
            return res;
        }

        public void makeRes(int index,boolean[] isUsed,int length){
            if (res == 26){
                return;
            }
            for (int i = index;i<arr.size();i++){
                int j = 0;
                String str = arr.get(i);
                boolean[] tmp = isUsed.clone();
                boolean isSame = false;
                while (j<str.length()){
                    if (!isUsed[str.charAt(j) - 'a']){
                        isUsed[str.charAt(j)- 'a'] = true;
                        j++;
                    }else {
                        isSame = true;
                        break;
                    }
                }
                if (!isSame){
                    res = Integer.max(res,length + str.length());
                    makeRes(i + 1,isUsed,length+str.length());
                }
                isUsed = tmp;
            }
        }
    }

}
