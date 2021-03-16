package com.gox.juc.study;

import java.util.concurrent.Phaser;

public class Test016 {
    static void sleep(){
        try {
            Thread.sleep(1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        Phaser phaser = new TestPhaser();
        Thread thread1 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "一");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + "二");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + "三");
            phaser.arriveAndAwaitAdvance();
        });
        Thread thread2 = new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + "一");
            phaser.arriveAndAwaitAdvance();
            System.out.println(Thread.currentThread().getName() + "二");
            phaser.arriveAndAwaitAdvance();
            phaser.arriveAndDeregister();

        });
        thread1.setName("线程1");
        thread2.setName("线程2");
        phaser.bulkRegister(2);
        thread1.start();
        thread2.start();

    }

    static class TestPhaser extends Phaser {

        @Override
        protected boolean onAdvance(int phase, int registeredParties) {
            switch (phase) {
                case 0:
                    System.out.println("阶段1");
                    System.out.println("参与人数" + registeredParties);
                    sleep();
                    return false;
                case 1:
                    System.out.println("阶段2");
                    System.out.println("参与人数" + registeredParties);
                    sleep();
                    return false;
                case 2:
                    System.out.println("阶段3");
                    System.out.println("参与人数" + registeredParties);
                    sleep();
                    return true;
                default:
                    return true;
            }
        }
    }
}
