package com.gua.algorithm.sf;

// 本题为考试单行多行输入输出规范示例，无需提交，不计分。

import java.util.*;

public class 小朋友分2个班 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            try {
                String str = in.nextLine();
                func(str);
            } catch (Exception e) {
                System.out.println("ERROR");
            }
        }
    }

    private static void func(String str) {
        String[] sA = str.split(" ");
        TreeSet<Integer> aSet = new TreeSet();
        TreeSet<Integer> bSet = new TreeSet();
        for (int i = 0; i < sA.length - 1; i++) {
            String[] end = sA[sA.length - 1 - i].split("/");
            String[] first = sA[sA.length - 1 - i - 1].split("/");
            if (i == 0) {
                if (end[1].equals("Y")) {
                    aSet.add(Integer.valueOf(end[0]));
                    aSet.add(Integer.valueOf(first[0]));
                } else {
                    aSet.add(Integer.valueOf(end[0]));
                    bSet.add(Integer.valueOf(first[0]));
                }
            } else {
                if (end[1].equals("Y")) {
                    if (aSet.contains(Integer.valueOf(end[0]))) {
                        aSet.add(Integer.valueOf(first[0]));
                    } else {
                        bSet.add(Integer.valueOf(first[0]));
                    }

                } else {
                    if (aSet.contains(Integer.valueOf(end[0]))) {
                        bSet.add(Integer.valueOf(first[0]));
                    } else {
                        aSet.add(Integer.valueOf(first[0]));
                    }
                }
            }


        }
        if (aSet.first() > bSet.first()) {
            for (Integer integer : bSet) {
                System.out.print(integer + " ");
            }
            System.out.println();
            for (Integer integer : aSet) {
                System.out.print(integer + " ");
            }
        } else {
            for (Integer integer : aSet) {
                System.out.print(integer + " ");
            }
            System.out.println();
            for (Integer integer : bSet) {
                System.out.print(integer + " ");
            }
        }
    }
}