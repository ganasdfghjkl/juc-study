package com.gox.juc.study;

/**
 * wait notify  测试代码
 *
 * @author
 */
public class Test004 {

    public static void main(String[] args) throws InterruptedException {
        new Thread(() -> {
            synchronized (Test004.class) {
                System.out.println("执行wait");
                try {
                    Test004.class.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("等待结束");
            }
        }).start();
        Thread.sleep(100L);
        new Thread(()->{
            synchronized (Test004.class) {
                System.out.println("执行通知可以启动");
                Test004.class.notify();
                System.out.println("即将释放锁");
            }
            try {
                Thread.sleep(10L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("睡眠之后");
        }).start();
    }
}
