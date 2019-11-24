package Offer.a21栈的压入弹出序列;

import java.util.ArrayList;
import java.util.Stack;

public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        Stack<Integer> stack = new Stack<>();
        int length = pushA.length;
        if (length == 0) {
            return false;
        }
        int i = 1;
        int j = 0;
        stack.push(pushA[0]);
        while (true) {
            while (j<length && popA[j] == stack.peek()){
                j++;
                stack.pop();
            }
            if (i == length){
                break;
            }
            stack.push(pushA[i]);
            i++;
        }
        return stack.isEmpty();
    }
}