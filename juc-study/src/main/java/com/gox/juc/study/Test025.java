package com.gox.juc.study;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 *
 */
public class Test025 {
    volatile static ReferenceQueue<Object> queue = new ReferenceQueue<>();

    public static void main(String[] args) {
        Object o = new Object();
        WeakReference<Object> objectWeakReference = new WeakReference<>(o,queue);
        new Thread(()->{
            while (true){
                Reference<?> poll = queue.poll();
                if (poll != null){
                    System.out.println("thread->gc回收");
                    System.out.println("thread->"+poll);
                    System.out.println("thread->"+poll.get());
                }
            }
        }).start();
        System.out.println(o);
        System.out.println(objectWeakReference.get());
        System.out.println(objectWeakReference);
        System.gc();
        System.out.println(o);
        System.out.println(objectWeakReference.get());
        System.out.println(objectWeakReference);
        o=null;
        System.gc();
        System.out.println(o);
        System.out.println(objectWeakReference.get());
        System.out.println(objectWeakReference);
    }
}
