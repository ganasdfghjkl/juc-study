package com.gox.juc.study;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Test017 {
    static ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    static Lock readLock = lock.readLock();
    static Lock writeLock = lock.writeLock();
    public static void main(String[] args) {
        Runnable read = () -> {
            try {
                readLock.lock();
                Thread.sleep(1000L);
                System.out.println("读完");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                readLock.unlock();
            }
        };
        Runnable write = () -> {
            try {
                writeLock.lock();
                Thread.sleep(1000L);
                System.out.println("写完");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                writeLock.unlock();
            }
        };
        for (int j = 0; j <5 ; j++) new Thread(write).start();
        for (int j = 0; j < 20 ; j++) new Thread(read).start();
    }
}
