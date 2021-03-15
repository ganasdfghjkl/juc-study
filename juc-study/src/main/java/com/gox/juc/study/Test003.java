package com.gox.juc.study;

/**
 * join 测试代码
 *
 * @author
 */
public class Test003 {

    public static void main(String[] args) throws InterruptedException {
        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("t2执行中");
        });
        Thread t1 = new Thread(() -> {
            synchronized (Test003.class) {
                System.out.println("等待t2执行结束");
                try {
                    t2.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("T2执行结束");
            }
        });
        t2.start();
        t1.start();
        new Thread(() -> {
            synchronized (Test003.class) {
                System.out.println("获得锁");
            }
        }).start();
    }
}
