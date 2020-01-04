package LeetCode.A1v300.A11v20.A020ValidParentheses;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> parentheses = new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{'){
                parentheses.push(s.charAt(i));
            }else if (parentheses.empty()){
                return false;
            }else if (parentheses.peek() == '(' && s.charAt(i) == ')'){
                parentheses.pop();
                continue;
            }else if (parentheses.peek() == '[' && s.charAt(i) == ']'){
                parentheses.pop();
                continue;
            }else if (parentheses.peek() == '{' && s.charAt(i) == '}'){
                parentheses.pop();
                continue;
            }else {
                return false;
            }

        }
        if (!parentheses.empty()){
            return false;
        }

        return true;
    }
}