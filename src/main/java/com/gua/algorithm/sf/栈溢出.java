package com.gua.algorithm.sf;

/**
 * 栈存放java方法，所以无限递归就可以让栈溢出
 */
public class 栈溢出 {
    public static void main(String[] args) {
        func();
    }

    public static void func(){
        func();
    }
}
