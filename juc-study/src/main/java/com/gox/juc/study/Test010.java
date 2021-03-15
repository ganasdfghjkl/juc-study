package com.gox.juc.study;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

public class Test010 {

    public static void main(String[] args) {
        AtomicInteger count = new AtomicInteger(0);
        List<Thread> list= new ArrayList<>();
        for (int i = 0; i <100 ; i++) {
            list.add(new Thread(()->{
                for (int j = 0; j <10000 ; j++) {
                    count.incrementAndGet();
                }
            }));
        }
        list.forEach(Thread::start);
        list.forEach(a->{
            try {
                a.join();
            }catch (Exception e){
                e.printStackTrace();
            }
        });
        System.out.println(count);
    }
}
