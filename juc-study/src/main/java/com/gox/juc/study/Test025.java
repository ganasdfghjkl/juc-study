package com.gox.juc.study;

import java.lang.ref.WeakReference;

/**
 *
 */
public class Test025 {
    public static void main(String[] args) {
        Object o = new Object();
        WeakReference<Object> objectWeakReference = new WeakReference<>(o);
        System.out.println(o);
        System.out.println(objectWeakReference.get());
        System.out.println(objectWeakReference);
        System.gc();
        o=null;
        System.out.println(o);
        System.out.println(objectWeakReference.get());
        System.out.println(objectWeakReference);
        System.gc();
        System.out.println(o);
        System.out.println(objectWeakReference.get());
        System.out.println(objectWeakReference);
    }
}
