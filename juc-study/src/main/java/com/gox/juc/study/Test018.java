package com.gox.juc.study;

import java.util.concurrent.Semaphore;

public class Test018 {

    public static void main(String[] args) {
        Semaphore s = new Semaphore(2);
        new Thread(()->{
            try {
                s.acquire();
                System.out.println("t1");
                Thread.sleep(100L);
                System.out.println("t1");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                s.release();
            }
        }).start();
        new Thread(()->{
            try {
                s.acquire();
                System.out.println("t2");
                Thread.sleep(100L);
                System.out.println("t2");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                s.release();
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();
                System.out.println("t3");
                Thread.sleep(100L);
                System.out.println("t3");
            }catch (InterruptedException e){
                e.printStackTrace();
            }finally {
                s.release();
            }
        }).start();
    }
}
