package A1v300.A151v160.A155MinStack;

import java.util.Stack;

public class Solution {

    class MinStack {

        Stack<Integer> data = new Stack<>();
        Stack<Integer> min = new Stack<>();

        /** initialize your data structure here. */
        public MinStack() {

        }

        public void push(int x) {
            if (data.isEmpty()){
                data.add(x);
                min.add(x);
            }else {
                int m = min.peek();
                if (m <=x){
                    min.add(m);
                }else {
                    min.add(x);
                }
                data.add(x);
            }

        }

        public void pop() {
            min.pop();
            data.pop();
        }

        public int top() {
            return data.peek();
        }

        public int getMin() {
            return min.peek();
        }
    }

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
