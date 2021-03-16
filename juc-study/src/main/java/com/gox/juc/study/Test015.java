package com.gox.juc.study;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class Test015 {

    public static void main(String[] args) throws InterruptedException {
        CyclicBarrier barrier = new CyclicBarrier(200,()-> System.out.println("芜湖---起飞"));
        for (int i = 0; i < 150 ; i++) {
            Thread.sleep(100L);
            new Thread(()->{
                try {
                    barrier.await(1000L, TimeUnit.MICROSECONDS);
                    System.out.println("起飞");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                } catch (TimeoutException e) {
                    e.printStackTrace();
                }
            }).start();
        }
    }
}
