package weekCompetition;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class C154 {

    class Solution {
        public int maxNumberOfBalloons(String text) {
            Map<Character,Integer> times = new HashMap<>();
            String word = "balloon";
            for (char c : word.toCharArray()){
                times.put(c,0);
            }
            for (char c : text.toCharArray()){
                if (times.containsKey(c)){
                    times.put(c,times.get(c) + 1);
                }
            }
            times.put('l',times.get('l')/2);
            times.put('o',times.get('o')/2);
            int res = Integer.MAX_VALUE;
            for (int i : times.values()){
                res = Integer.min(i,res);
            }
            return res;
        }
    }

    class Solution2 {
        public String reverseParentheses(String s) {
            Stack<Character> res = new Stack<>();
            for (int i = 0;i<s.length();i++){
                if (s.charAt(i)!=')'){
                    res.push(s.charAt(i));
                }else {
                    String str = "";
                    while (res.peek()!= '('){
                        str = str + res.pop();
                    }
                    res.pop();
                    for (char c : str.toCharArray()){
                        res.push(c);
                    }
                }
            }
            String re = "";
            while (!res.isEmpty()){
                re = re + res.pop();
            }
            return new StringBuilder(re).reverse().toString();
        }
    }

    class Solution3 {
        public int kConcatenationMaxSum(int[] arr, int k) {
            int length = arr.length;
            if (length == 0 || k == 0){
                return 0;
            }
            int sum = 0;
            for (int i : arr){
                sum+=i;
            }
            sum = sum <0 ? 0 : sum;
            int maxSum = 0;
            int ma1 = -Integer.MAX_VALUE;
            int ma2 = -Integer.MAX_VALUE;
            for (int i : arr){
                maxSum = maxSum + i;
                if (maxSum < 0){
                    maxSum = 0;
                }
                ma1 = Integer.max(ma1,maxSum);
            }

            int[] arr2 = new int[arr.length*2];
            for (int i = 0;i<arr.length*2;i++){
                arr2[i] = arr[i%arr.length];
            }
            maxSum = 0;
            for (int i : arr2){
                maxSum = maxSum + i;
                if (maxSum < 0){
                    maxSum = 0;
                }
                ma2 = Integer.max(ma2,maxSum);
            }
            if (k == 1){
                return ma1;
            }else {
                return (int)(ma2 + (long)(k - 2)*sum)%(10^9 + 7);
            }
        }
    }

    class Solution4 {
        public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
            return null;
        }
    }
}
