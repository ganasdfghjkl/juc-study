package com.gox.juc.study;

import java.util.concurrent.locks.LockSupport;

/**
 *
 */
public class Test020 {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            synchronized (Test020.class) {
                for (int i = 0; i < 20; i++) {
                    System.out.println(i);
                    if (i == 5 || i == 10) {
                        LockSupport.park();
                    }
                    try {
                        Thread.sleep(100L);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
        thread.start();
        LockSupport.unpark(thread);
        try {
            Thread.sleep(600L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (Test020.class) {
            System.out.println("释放锁资源");
            LockSupport.unpark(thread);
        }
    }
}
