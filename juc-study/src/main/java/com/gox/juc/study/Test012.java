package com.gox.juc.study;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test012 {

    public static void main(String[] args) {
        Lock lock = new ReentrantLock();

        new Thread(()->{
            try{
                lock.lock();
                System.out.println("start---------------");
                Thread.sleep(5000L);
                System.out.println("end-----------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        new Thread(()->{
            boolean locked = false;
            try{
                locked = lock.tryLock(10L, TimeUnit.SECONDS);
                System.out.println("尝试获取锁："+locked);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (locked)lock.unlock();
            }
        }).start();


    }
}
