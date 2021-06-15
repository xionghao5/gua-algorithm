package com.gua.algorithm.sf;

import java.util.ArrayList;
import java.util.List;

/**
 * 堆存放对象实例和数组，让list不断装入对象，就能堆溢出
 */
public class 堆溢出 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        while (true){
            sb.append("hello world!");
            list.add(sb.toString());
        }
    }
}
