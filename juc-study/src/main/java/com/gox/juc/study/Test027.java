package com.gox.juc.study;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class Test027 {
    static class TestTask implements Delayed{

        Long time;
        String name;

        TestTask(Long time,String name){
            this.time = time;
            this.name = name;
        }
        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(time-System.currentTimeMillis(),TimeUnit.MILLISECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (getDelay(TimeUnit.MILLISECONDS)-(o.getDelay(TimeUnit.MILLISECONDS)) >0){
                return 1;
            }else if ((getDelay(TimeUnit.MILLISECONDS)-(o.getDelay(TimeUnit.MILLISECONDS)) <0)){
                return -1;
            }
            return 0;
        }

        @Override
        public String toString() {
            return "TestTask{" +
                    "time=" + time +
                    ", name='" + name + '\'' +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        DelayQueue<TestTask> delayQueue = new DelayQueue<>();
        delayQueue.put(new TestTask(System.currentTimeMillis() + 1000 * 10L,"10"));
        delayQueue.put(new TestTask(System.currentTimeMillis() + 1000 * 9L,"9"));
        delayQueue.put(new TestTask(System.currentTimeMillis() + 1000 * 1L,"1"));
        delayQueue.put(new TestTask(System.currentTimeMillis() + 1000 * 2L,"2"));
        delayQueue.put(new TestTask(System.currentTimeMillis() + 1000 * 3L,"3"));
        delayQueue.put(new TestTask(System.currentTimeMillis() + 1000 * 7L,"7"));
        delayQueue.put(new TestTask(System.currentTimeMillis() + 1000 * 8L,"8"));
        delayQueue.put(new TestTask(System.currentTimeMillis() + 1000 *5L,"5"));
        delayQueue.put(new TestTask(System.currentTimeMillis() + 1000*6L,"6"));

        for (int i = 0; i <10 ; i++) {
            TestTask testTask =delayQueue.take();
            System.out.println(testTask.toString());
        }
    }



}
