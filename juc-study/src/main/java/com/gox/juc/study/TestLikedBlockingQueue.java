package com.gox.juc.study;

import java.util.concurrent.LinkedBlockingQueue;

/**
 *
 */
public class TestLikedBlockingQueue {

    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue(5);




        Thread.sleep(1000L);
        new Thread(()->{
            for (int i = 0; i < 1000 ; i++) {
                try {
                    linkedBlockingQueue.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();





        new Thread(()->{
            for (int i = 0; i < 1000 ; i++) {
                try {
                    linkedBlockingQueue.put("str");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}
