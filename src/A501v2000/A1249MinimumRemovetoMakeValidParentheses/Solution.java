package A501v2000.A1249MinimumRemovetoMakeValidParentheses;

import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Character> stack = new Stack<>();
        int i = 0;
        int j = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
                i++;
                continue;
            }
            if (c == ')') {
                if (j + 1 > i) {
                    continue;
                } else {
                    stack.push(c);
                    j++;
                    continue;
                }
            }
            stack.push(c);
        }
        int dif = i - j;
        StringBuffer str = new StringBuffer();
        while (!stack.isEmpty()) {
            char c = stack.pop();
            if (c == '(') {
                if (dif == 0) {
                    str.append(c);
                    continue;
                } else {
                    dif--;
                    continue;
                }

            }
            str.append(c);
        }
        return str.reverse().toString();
    }
}