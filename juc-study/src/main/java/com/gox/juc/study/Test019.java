package com.gox.juc.study;

import java.util.concurrent.Exchanger;

public class Test019 {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();
        new Thread(()->{
            String str = "哈哈哈";
            try {
                str = exchanger.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+str);
        },"T1").start();
        new Thread(()->{
            String str = "呵呵呵";
            try {
                Thread.sleep(1000L);
                str = exchanger.exchange(str);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+str);
        },"T2").start();
    }
}
