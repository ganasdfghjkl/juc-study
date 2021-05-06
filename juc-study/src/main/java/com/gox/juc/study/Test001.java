package com.gox.juc.study;

/**
 * 测试sleep 不会释放锁
 * @author
 */
public class Test001 {

    public void test(){
        System.out.println("aaaaaa");
    }

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            synchronized (Test001.class){
                System.out.println("睡眠之前");
                try {
                    Thread.sleep(10000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("睡眠之后");
            }
        }).start();
        Thread.sleep(100L);
        new Thread(()->{
            synchronized (Test001.class){
                System.out.println("得到锁");
            }
        }).start();
    }
}
