package com.gua.algorithm.sf;

import java.util.Scanner;

/**
 * 描述
 * 蛇形矩阵是由1开始的自然数依次排列成的一个矩阵上三角形。
 * <p>
 * 例如，当输入5时，应该输出的三角形为：
 * <p>
 * 1 3 6 10 15
 * <p>
 * 2 5 9 14
 * <p>
 * 4 8 13
 * <p>
 * 7 12
 * <p>
 * 11
 * <p>
 * <p>
 * 请注意本题含有多组样例输入。
 * <p>
 * 输入描述：
 * 输入正整数N（N不大于100）
 * <p>
 * 输出描述：
 * 输出一个N行的蛇形矩阵。
 * <p>
 * 示例1
 * 输入：
 * 4
 * 输出：
 * 1 3 6 10
 * 2 5 9
 * 4 8
 * 7
 */
public class 蛇形矩阵 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNextInt()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            func(a);
        }
    }

    public static void func(int a) {
        int y = 1;
        int yCount = 1;
        for (int i = 0; i < a; i++) {
            int x = y;
            int xCount = i + 2;

            for (int j = 0; j < a - i; j++) {
                System.out.print(x + " ");
                x += xCount;
                xCount++;
            }
            System.out.println();
            y += yCount;
            yCount++;
        }
    }
}
