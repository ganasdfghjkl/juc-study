package com.gqx.test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *
 */
public class TestFullGc001 {
    public static class CardInfo{
        BigDecimal bigDecimal = new BigDecimal(0.0);
        String name = "张三";
        int age = 5;
        Date birthDay = new Date();
        public void m(){
        }
    }
    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(50,new ThreadPoolExecutor.DiscardOldestPolicy());

    public static void main(String[] args) throws InterruptedException {
        executor.setMaximumPoolSize(50);
        for (;;){
            modelFit();
            Thread.sleep(100L);
        }
    }

    private static void modelFit(){
        List<CardInfo> taskList = getAllCardInfo();
        taskList.forEach(a->{
            executor.scheduleWithFixedDelay(()->a.m(),2,3, TimeUnit.SECONDS);
        });
    }
    private static List<CardInfo> getAllCardInfo(){
        List<CardInfo> cardInfoList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            CardInfo cardInfo = new CardInfo();
            cardInfoList.add(cardInfo);
        }
        return cardInfoList;
    }
}

