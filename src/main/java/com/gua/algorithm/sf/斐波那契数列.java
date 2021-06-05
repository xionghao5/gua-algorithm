package com.gua.algorithm.sf;

public class 斐波那契数列 {
    public static void main(String[] args) {
        int result = func(10);
        System.out.println(result);
        System.out.println("兔子：" + rabbit(10));
    }

    public static int func(int n) {
        if (n < 2) {
            return n;
        }
        int count = 0;
        int s0 = 0;
        int s1 = 1;
        for (int i = 0; i < n - 1; i++) {
            count = s0 + s1;
            s0 = s1;
            s1 = count;
        }
        return count;
    }

    public static int rabbit(int n) {
        if (n <= 2) {
            return 1;
        }
        int count = 0;
        int s1 = 1;
        int s2 = 1;
        for (int i = 0; i < n - 2; i++) {
            count = s1 + s2;
            s1 = s2;
            s2 = count;

            System.out.println(count);
        }
        return count;
    }
}
