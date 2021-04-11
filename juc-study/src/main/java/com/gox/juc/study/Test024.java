package com.gox.juc.study;

import java.lang.ref.SoftReference;

/**
 *
 */
public class Test024 {
    public static void main(String[] args) {
        SoftReference<byte[]> softReference = new SoftReference<>(new byte[1024*1024*10]);
        System.out.println(softReference);
        System.out.println(softReference.get());
        byte[] bytes = new byte[1024*1024*11];
        System.out.println(softReference.get());
        System.out.println(softReference);
    }

}
