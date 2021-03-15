package com.gox.juc.study;

/**
 *  锁重入测试，和异常锁丢失
 * @author
 */
public class Test005 {

    public static void main(String[] args) {
        TTT ttt = new TTT();
        new Thread(()->{
            ttt.test();
        }).start();
        new Thread(()->{
            synchronized (ttt){
                System.out.println(Thread.currentThread().getName()+"获得锁");
            }
        }).start();
    }
}

class TT{
    synchronized void test(){
        try {
            int i=1/0;
        }catch (Exception e){
        }
        System.out.println("TT......");
    }
}
class TTT extends TT {
    @Override
    synchronized void test() {
        System.out.println(Thread.currentThread().getName()+"持有锁");
        super.test();
        System.out.println("TTT.........");
    }
}
