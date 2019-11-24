package A1v300.A1v10.A010RegularExpressionMatching;

/*
算法思想：
带备忘的动态规划，用back[i][j]记录下s[i...]和p[j...]不匹配的情况。
把动态规划应用于回溯算法，通过back数组剪枝。

正确匹配的定义：
考虑到'.*'可以匹配空字符串，所以p匹配s的形式化定义为：p.isEmpty()&&s.isEmpty()

边界处理：
定义back[t.length+1][p.length+1]，额外增加两行哨兵处理边界。
如当i==t.length，j==p.length时,表示当前过程处理的text，pattern为空。

递归方程：
i==t.length&&j==p.length :               return true
p[j...] contain'*' :                     dp(i,j)=dp(i,j+2)||(firstmatch&&dp(i+1,j))
p[j...] !contain'*' && firstmatch :      dp(i,j)=dp(i+1,j+1)
p[j...] !contain'*' && !firstmatch :     return false

可能发生的重叠子问题，dp(i,j)到dp(i+2,j+2):
dp(i,j)->dp(i+1,j)->dp(i+1,j)->dp(i,j+2)
dp(i,j)->dp(i,j+2)->dp(i+1,j)->dp(i+1,j)
 */

enum Result {
    /*
    true,false
     */
    TRUE, FALSE
}

class Solution {
    Result[][] memo;

    public boolean isMatch(String text, String pattern) {
        memo = new Result[text.length() + 1][pattern.length() + 1];
        return dp(0, 0, text, pattern);
    }

    public boolean dp(int i, int j, String text, String pattern) {
        text.matches(pattern);
        if (memo[i][j] != null) {
            return memo[i][j] == Result.TRUE;
        }
        boolean ans;
        if (j == pattern.length()){
            ans = i == text.length();
        } else{
            boolean first_match = (i < text.length() &&
                    (pattern.charAt(j) == text.charAt(i) ||
                            pattern.charAt(j) == '.'));

            if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                ans = (dp(i, j+2, text, pattern) ||
                        first_match && dp(i+1, j, text, pattern));
            } else {
                ans = first_match && dp(i+1, j+1, text, pattern);
            }
        }
        memo[i][j] = ans ? Result.TRUE : Result.FALSE;
        return ans;
    }

}

/*
算法思想：
自底向上的动态规划，使用b[i][j]表示p[j...length-1]是否匹配t[i...length](t[length]为哨兵表示空)

边界处理:
定义back[text.length+1][pattern.length+1]，额外增加两行哨兵处理边界。
b[t.length][p.length]=true               (表示t和p都为空)
b[0...t.length-1][p.length]=false        (表示t不空，p为空，一定为false）
b[t.length][0...p.length-1]              (表示t为空，p不为空，p匹配t为空的情况)

状态转移方程：
i==t.length&&j==p.length:                b[i][j]=true
p[j...] contain'*':                      b[i][j]=b[i][j+2]||(firstmatch&&b[i+1][j])
p[j...] !contain'*' && firstmatch :      b[i][j]=b[i+1][j+1]
p[j...] !contain'*' && !firstmatch :     return false

规划子问题的解决顺序：
从p的最后一个字符subp开始匹配空字符、t的最后一个字符、从t的最后一个字符开始向前递增的字串，结束一个循环后，subp向前递增。
也就是从矩阵b[0...t.length][0...p.length-1]从下到上，从左到右的顺序，最后得到的b[0][0]就是答案。

 */

class Solution2{
    public static boolean isMatch(String text, String pattern) {
        boolean[][] dp = new boolean[text.length() + 1][pattern.length() + 1];
        dp[text.length()][pattern.length()] = true;

        for (int i = text.length(); i >= 0; i--){
            for (int j = pattern.length() - 1; j >= 0; j--){
                boolean first_match = (i < text.length() &&
                        (pattern.charAt(j) == text.charAt(i) ||
                                pattern.charAt(j) == '.'));
                if (j + 1 < pattern.length() && pattern.charAt(j+1) == '*'){
                    dp[i][j] = dp[i][j+2] || first_match && dp[i+1][j];
                } else {
                    dp[i][j] = first_match && dp[i+1][j+1];
                }
            }
        }
        for (int a = 0 ; a < text.length() + 1  ; a++){
            String res = "";
            for (int b = 0 ; b < pattern.length() + 1  ; b++){
                res =res + " " + dp[a][b];
            }
            System.out.println(res);
        }

        return dp[0][0];
    }


    public static void main(String[] args) {
        Solution2.isMatch("aabc","a.bc");
    }
}