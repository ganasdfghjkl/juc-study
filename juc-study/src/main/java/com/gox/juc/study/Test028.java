package com.gox.juc.study;

import java.util.concurrent.SynchronousQueue;

/**
 *
 */
public class Test028 {
    public static void main(String[] args) throws InterruptedException {
        SynchronousQueue<String> queue  = new SynchronousQueue<>();

        for (int i = 0; i <10 ; i++) {
         new Thread(()->{
             try {
                 System.out.println(queue.take());
             } catch (InterruptedException e) {
                 e.printStackTrace();
             }
         }).start();
        }
        for (int i = 0; i <10 ; i++) {
            System.out.println(i);
            queue.put(i+"thread");
        }


    }
}
