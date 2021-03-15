package com.gox.juc.study;

/**
 * 测试yield
 *
 * @author
 */
public class Test002 {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (Test002.class) {
                System.out.println("谦让");
                Thread.yield();
                System.out.println("谦让");
                Thread.yield();
                System.out.println("谦让");
                Thread.yield();
                System.out.println("谦让");
                Thread.yield();
            }
        }).start();
        new Thread(() -> {
            System.out.println("不获得锁");
        }).start();
        new Thread(() -> {
            synchronized (Test002.class) {
                System.out.println("得到锁");
            }
        }).start();
    }
}
