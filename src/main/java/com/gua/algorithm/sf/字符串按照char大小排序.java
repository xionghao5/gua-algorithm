package com.gua.algorithm.sf;

import java.util.Scanner;

/**
 * 描述
 * Lily上课时使用字母数字图片教小朋友们学习英语单词，每次都需要把这些图片按照大小（ASCII码值从小到大）排列收好。请大家给Lily帮忙，通过C语言解决。
 * <p>
 * 本题含有多组样例输入。
 * <p>
 * <p>
 * 输入描述：
 * Lily使用的图片包括"字符串只换填一次使字符串最小"到"Z"、"a"到"z"、"0"到"9"。输入字母或数字个数不超过1024。
 * <p>
 * 输出描述：
 * Lily的所有图片按照从小到大的顺序输出
 * <p>
 * 示例1
 * 输入：
 * Ihave1nose2hands10fingers
 * 输出：
 * 0112Iaadeeefghhinnnorsssv
 */
public class 字符串按照char大小排序 {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) {
            String a = in.nextLine();

            System.out.println(func(a));
        }
    }

    public static String func(String a) {
        char[] b = a.toCharArray();
        for (int i = 0; i < b.length - 1; i++) {
            for (int j = 0; j < b.length - 1 - i; j++) {
                if (b[j] > b[j + 1]) {
                    char temp = b[j];
                    b[j] = b[j + 1];
                    b[j + 1] = temp;
                }
            }
        }
        String result = "";
        for (int i = 0; i < b.length; i++) {
            result += b[i];
        }
        return result;
    }
}