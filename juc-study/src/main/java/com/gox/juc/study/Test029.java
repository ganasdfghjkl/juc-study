package com.gox.juc.study;

import java.util.concurrent.LinkedTransferQueue;

/**
 *
 */
public class Test029 {
    public static void main(String[] args) throws InterruptedException {
        LinkedTransferQueue<String> strings = new LinkedTransferQueue<>();
        new Thread(()->{
            while (true){
                try {
                    System.out.println(strings.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        strings.put("aa");
        System.out.println("put");
        strings.add("bb");
        System.out.println("add");
        strings.transfer("ccc");
        System.out.println("transfer");

    }
}
