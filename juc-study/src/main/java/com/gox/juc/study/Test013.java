package com.gox.juc.study;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test013 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        Thread t1 = new Thread(()->{
            try{
                lock.lock();
                System.out.println("start---------------");
                Thread.sleep(10000L);
                System.out.println("end-----------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        });
        t1.start();
        Thread t2 =  new Thread(()->{
            try{
                try {
                    lock.lockInterruptibly();
                    System.out.println("获取锁成功");
                } catch (InterruptedException e) {
                    System.out.println("1qqqqqqq");
                    e.printStackTrace();
                }
            }  finally {
                lock.unlock();
            }
        });
        t2.start();
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.interrupt();
    }
}
