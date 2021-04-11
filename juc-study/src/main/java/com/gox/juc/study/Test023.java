package com.gox.juc.study;

import java.util.concurrent.CountDownLatch;

/**
 *
 */
public class Test023 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        new Thread(()->{
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("aaaaaaaaa");
        }).start();

        new Thread(()->{
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("bbbbbbb");
        }).start();
        new Thread(()->{
            try {
                countDownLatch.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("cccccccc");
        }).start();

        countDownLatch.countDown();
        countDownLatch.countDown();
        countDownLatch.countDown();
        System.out.println("xxxxx");


    }
}
