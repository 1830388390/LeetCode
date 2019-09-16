package A71v80.A071SimplifyPath;

import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        int l = path.length();
        if (l == 0) {
            return "/";
        }
        Stack<String> catalog = new Stack<>();
        for (int i = 0; i <= l - 1; i++) {
            String str = "";
            while (path.charAt(i) != '/') {
                str = str + path.charAt(i);
                if (i + 1<=l-1&&path.charAt(i + 1) !='/'){
                    i++;
                }else {
                    break;
                }
            }
            if (str.equals("..")) {
                if (catalog.empty()){
                    continue;
                }
                catalog.pop();
                continue;
            }
            if (str.equals(".")) {
                continue;
            }
            if (!str.equals("")){
                catalog.add(str);
                continue;
            }

        }
        String res = "";
        if (catalog.empty()){
            return "/";
        }
        while (!catalog.empty()){
            res = "/" + catalog.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().simplifyPath(new String("/home//foo/")));
    }
}