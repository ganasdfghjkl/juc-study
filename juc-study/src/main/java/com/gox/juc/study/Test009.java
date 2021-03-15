package com.gox.juc.study;

import java.util.Objects;

public class Test009 {

    static int i = 30;


    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        new Thread(()->{
            synchronized (Test009.class){
                while (Boolean.TRUE){
                   if (i!= 30){
                       System.out.println("i的新值为："+i);
                   }
                }
            }
        }).start();
        Thread.sleep(100L);
        i++;
        System.out.println("i的新值为："+i);

    }

}
