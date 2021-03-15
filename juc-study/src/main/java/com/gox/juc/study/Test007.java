package com.gox.juc.study;

public class Test007 {
    private static volatile boolean R = Boolean.TRUE;
    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            System.out.println("start");
            while (R){
            }
            System.out.println("end");
        }).start();
        Thread.sleep(1000L);
        R = Boolean.FALSE;
        System.out.println("修改之后的值为："+R);
    }
}
