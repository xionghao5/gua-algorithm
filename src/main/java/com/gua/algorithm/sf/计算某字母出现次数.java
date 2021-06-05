package com.gua.algorithm.sf;

import java.util.Scanner;

/**
 * 描述
 * 写出一个程序，接受一个由字母、数字和空格组成的字符串，和一个字母，然后输出输入字符串中该字母的出现次数。不区分大小写，字符串长度小于500。
 *
 * 输入描述：
 * 第一行输入一个由字母和数字以及空格组成的字符串，第二行输入一个字母。
 *
 * 输出描述：
 * 输出输入字符串中含有该字符的个数。
 *
 * 示例1
 * 输入：
 * ABCabc
 * 字符串只换填一次使字符串最小
 * 输出：
 * 2
 */
public class 计算某字母出现次数 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextLine()) { // 注意 while 处理多个 case
            String str = in.nextLine();
            String a = in.nextLine();
            func(str, a);
        }
    }

    private static void func(String str, String a) {
        a= a.toLowerCase();
        char cha = a.charAt(0);
        str = str.toLowerCase();
        int count = 0;
        for (char ch : str.toCharArray()) {
            if(ch == cha){
                count++;
            }
        }
        System.out.println(count);
    }
}
