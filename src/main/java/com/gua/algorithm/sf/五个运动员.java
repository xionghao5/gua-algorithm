package com.gua.algorithm.sf;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 一个主线程（裁判），5个线程（运动员，速度不一）；5个线程结束，主线程才能结束。
 */
public class 五个运动员 {
    private static ExecutorService service = Executors.newCachedThreadPool();

    private static Map<Integer, Boolean> concurrentHashMap = new ConcurrentHashMap<>();

    public static void main(String[] args) {
        func();
    }

    public static void func() {
        for (int i = 0; i < 5; i++) {
            service.execute(new Yundongyuan(i, i, concurrentHashMap));
        }
        while (true){
            if(concurrentHashMap.size() == 5){
                System.out.println(concurrentHashMap.size());
                break;
            }
            System.out.println(concurrentHashMap.size());
        }
        service.shutdown();
    }
}

class Yundongyuan implements Runnable {

    private int id;
    private int sudu;
    private Map<Integer, Boolean> map;
    private Boolean flag;

    public Yundongyuan(int id, int sudu, Map<Integer, Boolean> map) {
        this.id = id;
        this.sudu = sudu;
        this.map = map;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(sudu * 1000);
            flag = true;
            map.put(id, flag);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}