package com.gox.juc.study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

public class Test011 {

    static Long count1 = 0L;
    static AtomicLong count2 = new AtomicLong(0);
    static LongAdder count3 = new LongAdder();

    public static void main(String[] args) {
        List<Thread> list = new ArrayList<>();
        for (int i = 0; i <1000 ; i++) {
            list.add(new Thread(()->{
                for (int j = 0; j <100000 ; j++) {
                    synchronized (Test011.class){
                        count1++;
                    }
                }
            }));
        }
        Long timeStart1 = System.currentTimeMillis();
        list.forEach(Thread::start);
        list.forEach(a->{
            try {
                a.join();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        Long timeEnd1 = System.currentTimeMillis();
        System.out.println("sync "+count1+"     "+(timeEnd1-timeStart1));
        System.out.println("====================================");
        list.clear();
        for (int i = 0; i <1000 ; i++) {
            list.add(new Thread(()->{
                for (int j = 0; j <100000 ; j++) {
                    count2.incrementAndGet();
                }
            }));
        }
        Long timeStart2 = System.currentTimeMillis();
        list.forEach(Thread::start);
        list.forEach(a->{
            try {
                a.join();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        Long timeEnd2 = System.currentTimeMillis();
        System.out.println("atom "+count2+"     "+(timeEnd2-timeStart2));
        System.out.println("====================================");
        list.clear();
        for (int i = 0; i <1000 ; i++) {
            list.add(new Thread(()->{
                for (int j = 0; j <100000 ; j++) {
                    count3.increment();
                }
            }));
        }
        Long timeStart3 = System.currentTimeMillis();
        list.forEach(Thread::start);
        list.forEach(a->{
            try {
                a.join();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        Long timeEnd3 = System.currentTimeMillis();
        System.out.println("addr "+count2+"     "+(timeEnd3-timeStart3));


    }
}
