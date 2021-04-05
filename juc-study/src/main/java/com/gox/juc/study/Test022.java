package com.gox.juc.study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 */
public class Test022 {
    Lock lock = new ReentrantLock();
    Condition s = lock.newCondition();
    Condition r = lock.newCondition();
    int MAXSIZE = 10;
    private List list = new ArrayList();
    private void add(){
        try {
            lock.lock();
            while (list.size() == MAXSIZE){
                s.await();
            }
            System.out.println("添加一个数据");
            list.add(new Object());
            r.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
    private void get(){
        try {
            lock.lock();
            while (list.size() == 0){
                r.await();
            }
            System.out.println("取出第一个数据");
            list.remove(0);
            s.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Test022 test022 = new Test022();
        for (int i = 0; i <3 ; i++) {
            new Thread(()->{
                for (int j = 0; j < 10 ; j++) {
                    test022.add();
                }
            }).start();
        }
        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                for (int j = 0; j < 3 ; j++) {
                    test022.get();
                }
            }).start();
        }

    }



}
