package com.gox.juc.study;

import java.lang.ref.PhantomReference;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

/**
 *
 */
public class Test026 {
    volatile static ReferenceQueue<Object> queue = new ReferenceQueue<>();
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        PhantomReference phantomReference = new PhantomReference(o,queue);
        WeakReference weakReference = new WeakReference(o);
        new Thread(()->{
            while (true){
                Reference<?> poll = queue.poll();
                if (poll != null){
                    System.out.println("gc回收");
                    System.out.println(weakReference.get());
                    System.out.println(weakReference);
                    System.out.println(phantomReference);
                    System.out.println(poll);
                    System.out.println(poll.get());
                }
            }
        }).start();
        System.gc();
        System.out.println("main->"+weakReference.get());
        System.out.println("main->"+phantomReference.get());
        o = null;
        System.gc();
        System.out.println("main->"+weakReference.get());
    }
}
