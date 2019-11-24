package Offer.a44翻转单词序列;

import java.util.Stack;

public class Solution {
    public String ReverseSentence(String str) {
        if (str.trim().equals("") && str.length() > 0) {
            return str;
        }
        Stack<String> reverse = new Stack<>();
        String string = str.trim();
        String[] strings = string.split(" ");
        for (int i = 0; i < strings.length; i++) {
            reverse.push(strings[i]);
        }
        string = reverse.pop();
        while (!reverse.isEmpty()) {
            string = string + " " + reverse.pop();
        }
        return string;
    }
}