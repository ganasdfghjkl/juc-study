package com.gox.juc.study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 *
 */
public class Test021 {
    List list = new ArrayList();

    void add(Object o){
        list.add(o);
    }
    int size(){
        return list.size();
    }

    public static void main(String[] args) {
        Test021 test021 = new Test021();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(1);

        new Thread(()->{
            if (test021.size() < 5){
                try {
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("t2结束");
            countDownLatch2.countDown();
        }).start();
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(()->{
            for (int i = 0; i <10 ; i++) {
                System.out.println(i);
                test021.add(new Object());
                if (i == 4){
                    countDownLatch.countDown();
                    try {
                        countDownLatch2.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

            }
        }).start();



    }

}
