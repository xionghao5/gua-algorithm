package com.gua.algorithm.sf;

import java.util.*;

public class 键值对 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 注意 hasNext 和 hasNextLine 的区别
        while (in.hasNext()) { // 注意 while 处理多个 case
            int a = in.nextInt();
            TreeMap<Integer, Integer> treeMap = new TreeMap<>();
            for (int i = 0; i < a; i++) {
                int key = in.nextInt();
                int value = in.nextInt();
                if (treeMap.containsKey(key)) {
                    Integer r = treeMap.get(key);
                    treeMap.put(key, value + r);
                } else {
                    treeMap.put(key, value);
                }
            }
            for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }
}
