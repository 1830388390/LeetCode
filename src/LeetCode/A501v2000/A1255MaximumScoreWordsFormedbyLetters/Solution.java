package LeetCode.A501v2000.A1255MaximumScoreWordsFormedbyLetters;

class Solution {
    int res;
    String[] words;
    int[] score;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        this.words = words;
        this.score = score;
        int[] wordNum = new int[26];//每个字母可用次数
        this.res = 0;
        for (char c : letters) {
            wordNum[c - 'a']++;
        }
        DFS(0, 0, wordNum);
        return res;
    }

    private void DFS(int index, int sum, int[] wordNum) {

        if (index >= words.length) {
            return;
        }

        int[] tmpWordNum = wordNum.clone();//临时数组,用于不放入背包的情况
        int tmpSum = 0;
        String str = words[index];
        for (char c : str.toCharArray()) {
            if (wordNum[c - 'a'] > 0) {
                tmpSum = tmpSum + score[c - 'a'];
                wordNum[c - 'a']--;
            } else {
                DFS(index + 1, sum, tmpWordNum);
                return;
            }
        }
        res = Integer.max(res, sum + tmpSum);

        DFS(index + 1, sum + tmpSum, wordNum);//放入背包

        DFS(index + 1, sum, tmpWordNum);//不放入背包
    }

}