package Offer.a27字符串的排列;

import java.util.*;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * 例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 */
public class Solution {

    Set<String> res = new HashSet<>();

    public ArrayList<String> Permutation(String str) {
        if (str.length() == 0){
            return new ArrayList<>();
        }
        char[] words = new char[str.length()];
        int i = 0;
        for (char c : str.toCharArray()){
            words[i++] = c;
        }
        makeRes(str.length(),0,words);
        ArrayList<String> ret = new ArrayList<>(res);
        Collections.sort(ret, (o1, o2) -> {
            char[] chars1=o1.toCharArray();
            char[] chars2=o2.toCharArray();
            int i1 =0;
            while(i1 <chars1.length && i1 <chars2.length){
                if(chars1[i1]>chars2[i1]){
                    return 1;
                }else if(chars1[i1]<chars2[i1]){
                    return -1;
                }else{
                    i1++;
                }
            }
            if(i1 ==chars1.length){  //o1到头
                return -1;
            }
            if(i1 == chars2.length){ //o2到头
                return 1;
            }
            return 0;
        });
        return ret;
    }

    public void makeRes(int length,int index,char[] words){
        res.add(String.valueOf(words));
        for (int i = index;i<length;i++){
            this.swap(words,i,index);
            makeRes(length, index + 1, words);
            this.swap(words,i,index);
        }
    }

    private void swap(char[] words,int first,int second){
        char tmp = words[first];
        words[first] = words[second];
        words[second] = tmp;
    }
}