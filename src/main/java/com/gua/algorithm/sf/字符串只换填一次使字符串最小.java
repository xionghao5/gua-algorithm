package com.gua.algorithm.sf;

import java.util.*;

public class 字符串只换填一次使字符串最小 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            String a = in.nextLine();
            char[] ch = a.toCharArray();
            TreeMap<Character,Integer> treeMap= new TreeMap<>();
            for (int i = 0; i <ch.length ; i++) {
                treeMap.put(ch[i],i);
            }
            Collection<Integer> values = treeMap.values();
            Integer min = Collections.min(values);
            int i = 0;
            for (Map.Entry<Character, Integer> entry : treeMap.entrySet()) {
                if(entry.getValue()>i){
                    char temp = ch[entry.getValue()];
                    ch[entry.getValue()]= ch[i];
                    ch[i] = temp;
                }
                i++;
            }
            String result = "";
            for (char c : ch) {
             result+=c;
            }
            System.out.println(result);
        }
    }
}
