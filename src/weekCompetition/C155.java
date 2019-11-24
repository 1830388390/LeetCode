package weekCompetition;

import java.util.*;

public class C155 {

    class Solution {
        public List<List<Integer>> minimumAbsDifference(int[] arr) {
            int differ = Integer.MAX_VALUE;
            Arrays.sort(arr);
            List<List<Integer>> res = new ArrayList<>();
            for (int i = 1; i < arr.length; i++) {
                int newDiffer = arr[i] - arr[i - 1];
                if (newDiffer == differ) {
                    ArrayList<Integer> re = new ArrayList<>(2);
                    re.add(arr[i - 1]);
                    re.add(arr[i]);
                    res.add(re);
                } else if (newDiffer > differ) {
                    continue;
                } else if (newDiffer < differ) {
                    res = new ArrayList<>();
                    ArrayList<Integer> re = new ArrayList<>(2);
                    re.add(arr[i - 1]);
                    re.add(arr[i]);
                    res.add(re);
                    differ = newDiffer;
                }
            }
            return res;
        }
    }

    class Solution2 {
        public int nthUglyNumber(int n, int a, int b, int c) {
            int ia = 1;
            int ib = 1;
            int ic = 1;
            int res = 0;
            int i = 1;
            while (i <= n) {
                int na = a * ia == res ? a * (++ia) : a * ia;
                int nb = b * ib == res ? b * (++ib) : b * ib;
                int nc = c * ic == res ? c * (++ic) : c * ic;
                i++;
                res = Integer.min(na, Integer.min(nb, nc));
                System.out.println(res);
                if (res == na) {
                    ia++;
                    continue;
                }
                if (res == nb) {
                    ib++;
                    continue;
                }
                if (res == nc) {
                    ic++;
                    continue;
                }
            }
            return res;
        }
    }

    static class Solution3 {
        int[] words;
        Map<Integer,String> res;
        List<List<Integer>> pairs;
        public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
            this.pairs = pairs;
            words = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26};
            this.res = new HashMap<>();
            int wordCount = 0;
            int position = 1;
            for (int i = s.length() - 1; i >= 0; i--) {
                wordCount = wordCount + words[s.charAt(i) - 'a'] * position;
                position = position * 10;
            }
            makeRes(s,wordCount);
            int minC = Integer.MAX_VALUE;
            for (int i : res.keySet()){
                minC = Integer.min(minC,i);
            }
            return res.get(minC);
        }

        private void makeRes(String str,int oldCount){
            System.out.println(oldCount);
            boolean isBig = false;
            for (List<Integer> tmp : pairs){
                int a = tmp.get(0);
                int b = tmp.get(1);
                int newCount = getCount(str,a,b,oldCount);
                if (newCount < oldCount){
                    isBig = true;
                    StringBuilder sb = new StringBuilder(str);
                    String t = String.valueOf(str.charAt(a));
                    sb.replace(a,a+1,String.valueOf(str.charAt(b)));
                    sb.replace(b,b+1,t);
                    makeRes(sb.toString(),newCount);
                }
            }
            if (!isBig){
                res.put(oldCount,str);
            }
        }

        public int getCount(String str,int a,int b,int oldCount){
            return oldCount - words[str.charAt(a) - 'a']*(int)Math.pow(10,str.length() - a - 1) - words[str.charAt(b) - 'a']*(int)Math.pow(10,str.length() -b - 1)
                    +words[str.charAt(b) - 'a']*(int)Math.pow(10,str.length() -a - 1) + words[str.charAt(a) - 'a']*(int)Math.pow(10,str.length() -b - 1);
        }

    }
    public static void main(String[] args) {
        new Solution3().smallestStringWithSwaps("edykuy",new ArrayList<>());
    }
}
