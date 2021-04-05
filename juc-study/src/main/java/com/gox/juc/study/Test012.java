package com.gox.juc.study;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Test012 {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new ReentrantLock();
        lock.lock();
        System.out.println("asdasdasd");
        lock.unlock();

        lock.newCondition();
        new Thread(()->{
            try{
                lock.lock();
                System.out.println("start---------------");
                Thread.sleep(5000000L);
                System.out.println("end-----------------");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();
        Thread.sleep(1L);

        new Thread(()->{
            try{
                lock.lock();
                System.out.println("asdasdasd");
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }).start();


    }
}
