package com.gox.juc.study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Test014 {


    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(100);

        for (int i = 0; i <100 ; i++) {
            list.add( new Thread(()->{
                try {
                    Thread.sleep(1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("------");
                countDownLatch.countDown();
            }));
        }
        list.forEach(Thread::start);

        try {
            countDownLatch.await(2L, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("执行结束");
    }
}
